package com.tree.exil.model.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5415120947023621620L;
	private int userId;
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int usersCount) {
		this.userId = usersCount;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

	public UserModel(int userId,String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public UserModel(){
		
	}
	
	


}
