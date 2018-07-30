package com.tree.exil.model.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class HelloWorldModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5415120947023621620L;
	private String message;
	public HelloWorldModel(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HelloWorldModel [message=" + message + "]";
	}
	
	
	

	


}
