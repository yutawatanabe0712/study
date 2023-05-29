package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* ユーザー情報更新リクエストデータ
*
*/
@Data
@EqualsAndHashCode(callSuper = false)//@Dataを継承があるオブジェクトで使うと警告が出るため、使用。
public class UserUpdateRequest extends UserRequest implements Serializable {

	/**
	* ユーザーID
	*/
	@NotNull    //@NotNullアノテーションより、nullにできなくする
	
	private Integer id;

}
