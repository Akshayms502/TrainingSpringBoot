package com.tree.exil.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tree.exil.model.user.HelloWorldModel;

@RestController
public class HelloWorldController {

	@GetMapping(path="hello")
	public String helloWorld(){
		
		return "hello akshay";
	}
	
	@GetMapping(path="helloworld")
	public HelloWorldModel hello(){
		
		return new HelloWorldModel("hello akshay");
	}
	
	
	@GetMapping(path="hello1/{name}")
	public HelloWorldModel hello(@PathVariable String name){
		
		return new HelloWorldModel("hello"+name);
	}
	
	
}
