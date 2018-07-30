package com.tree.exil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tree.exil.model.user.UserModel;

@Component
public class UserDaoService {
	
	 private static List<UserModel> users = new ArrayList<>();
	 int usersCount=1;

	 static {

	 users.add(new UserModel(101,"Rupa","1234"));
	 users.add(new UserModel(102,"Kantri Maduvinakodi","345"));
	 users.add(new UserModel(103,"Ankit Kumar","567"));


	 }


	 public List<UserModel> hetAllUsers(){

	 return users;

	 }


	 public UserModel saveUser(UserModel user) {

	 if(user.getUserId()==0) {
	 user.setUserId(++usersCount);

	 }

	 users.add(user);
	 return user;

	 }



	 public UserModel getUser(int userId) {

	 for(UserModel user : users) {


	 if(user.getUserId()==userId) {
	 return user;

	 }
	 }
	 return null;

	 }


	 public UserModel deleteUser(int userId) {
		 for(UserModel user : users) {
		 
		 if(user.getUserId()==userId){
			 users.remove(user);
			 return user;
		 }
				 
		 }
		return null;
		 
	 

	 }

	 public UserModel updateUser(UserModel user) {


	 return null;
	 }


}
