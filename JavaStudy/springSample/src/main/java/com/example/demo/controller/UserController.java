package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  private UserService userService;

  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping("/user/list")
  public String displayList(Model model) {
    List<UserEntity> userlist = userService.searchAll();
    model.addAttribute("userlist", userlist);
    return "user/list";
  }

  /**
* ユーザー新規登録画面を表示
* @param model Model
* @return ユーザー情報一覧画面
*/
  @GetMapping("/user/add")
  public String displayAdd(Model model) {
	  model.addAttribute("userRequest", new UserRequest());
	  return "user/add";
  }
  
  /**
* ユーザー新規登録
* @param userRequest リクエストデータ
* @param model Model
* @return ユーザー情報一覧画面
*/
  @PostMapping(value = "/user/create")//postで受け取る
  public String create(@Validated  UserRequest userRequest, BindingResult result, Model model) {//@Validatedより、UserRequestのバリデーションを効かしている。@ModelAttributeより、
    if (result.hasErrors()) {//Errorsインターフェースを継承したBindingResultクラスより、hasErrorsメソッドによってエラーがあった場合trueを返す。
      // エラーがtrueだった場合
      List<String> errorList = new ArrayList<String>();//errorListというString型のArrayListを作成。
      for (ObjectError error : result.getAllErrors()) {//拡張for文。BindingResultクラスのgetAllErrorsメソッドより、エラーをList型にして、そのエラーすべてを順に
        errorList.add(error.getDefaultMessage());//エラー文をerrorリストの末尾に付け加えていく
      }
      model.addAttribute("validationError", errorList);//Viewに上記の情報を渡すために、ModelクラスのaddAttributeメソッドより、エラー文が入っているerrorListをvalidationErrorという名前で渡す。
      return "user/add";
    }
    // ユーザー情報の登録
    userService.create(userRequest);//userServiceクラスより、createメソッドを使用して新規登録を行い、最後にユーザー情報一覧まで表示している。
    return "redirect:/user/list";
  }
  
  
  /**
* ユーザー情報詳細画面を表示
* @param id 表示するユーザーID
* @param model Model
* @return ユーザー情報詳細画面
*/
  @RequestMapping(value="/user/{id}")
  public String displayView(@PathVariable Integer id, Model model) {
	  return "user/view";
  }
}