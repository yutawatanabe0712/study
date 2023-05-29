package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)

public class UserService {

  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<UserEntity> searchAll() { 
    return userRepository.findAll();
  }
  
  /**
* ユーザー情報 主キー検索
* @return 検索結果
*/
  public UserEntity findById(Integer id) {//引数には後ほど動的に受け取ることになるidを入れる
	    return userRepository.findById(id).get();//userRepositoryクラスの、findByIdメソッドより、引数に入ってきたid先のデータを
	  }

  
  /**
* ユーザー情報 新規登録
* @param user ユーザー情報
*/
  public void create(UserRequest userRequest) { //引数にUserRequestを設置
	  Date date = new Date(); //Dateクラスのインスタンス化して変数nowに位置情報を格納
	  UserEntity user = new UserEntity();//UserEntityクラスをインスタンス化して変数userに位置情報を格納
	  user.setName(userRequest.getName());//UserEntityクラスのメソッドsetName(セッター)より、userRequestクラスのgetName(ゲッター)を入れる。
	  user.setAddress(userRequest.getAddress()); //UserEntityクラスのメソッドsetAddress(セッター)より、userRequestクラスのgetAddress(ゲッター)を入れる。 
	  user.setPhone(userRequest.getPhone());//UserEntityクラスのメソッドsetPhone(セッター)より、userRequestクラスのgetPhone(ゲッター)を入れる。
	  user.setCreateDate(date);//UserEntityクラスのメソッドsetCreateDate(セッター)より、Dateクラスを引数に入れている
	  user.setUpdateDate(date);//UserEntityクラスのメソッドsetUpdateDate(セッター)より、Dateクラスを引数に入れている
	  userRepository.save(user);//userRepositoryクラスのsaveメソッドより、引数にUserEntityクラスを入れている。
	  }
  
  /**
* ユーザー情報 更新
* @param user ユーザー情報
*/
  public void update(UserUpdateRequest userUpdateRequest) {
	UserEntity user = findById(userUpdateRequest.getId());//findByIdメソッドより、userUpdateRequestクラスのgetIゲッターより、idを引数に入れて、id検索。検索して取ってきたデータをuserに格納。
	user.setName(userUpdateRequest.getName());
	user.setPhone(userUpdateRequest.getPhone());
	user.setUpdateDate(new Date());
	userRepository.save(user);
	  
  }
}
