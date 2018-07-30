package com.tree.exil.controller;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPBinding;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tree.exil.exception.UserNotFound;
import com.tree.exil.model.user.UserModel;
import com.tree.exil.service.UserDaoService;

@RestController
public class UserResource {

	Logger logs = Logger.getLogger(UserResource.class);

	@Autowired
	private UserDaoService userService;

	@GetMapping("users")
	public List<UserModel> getAllUser() {
		return userService.hetAllUsers();
	}

	@GetMapping("/users1/{useId}")
	public UserModel getOneUser1(@PathVariable int userId) {
		System.out.println("userId:" + userId);
		if (userId == 0) {
			throw new UserNotFound();
		}
		return userService.getUser(userId);

	}

	@PostMapping("user")
	public void addUser(@RequestBody UserModel user) {
		UserModel model = userService.saveUser(user);
		System.out.println(model);

	}

	@PostMapping("user1")
	public ResponseEntity<Object> addUser1(@RequestBody UserModel user, HttpServletRequest req,
			HttpServletResponse res) {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(user.getUserId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping("users2/{useId}")
	public Resource<UserModel> getOneUser2(@PathVariable int userId) {
		UserModel getUser = userService.getUser(userId);
		if (userId == 0) {
			throw new UserNotFound();
		}

		Resource<UserModel> resource = new Resource<UserModel>(getUser);
		ControllerLinkBuilder linkTo = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getAllUser());

		resource.add(linkTo.withRel("all-users"));
		return resource;

	}

	@PostMapping("userAdd")
	public Resource<UserModel> addUser1(@RequestBody UserModel user) {
		UserModel model = userService.saveUser(user);

		ControllerLinkBuilder linkTo = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getOneUser1(model.getUserId()));
		Resource<UserModel> resource = new Resource<UserModel>(model);
		resource.add(linkTo.withRel("selected-users"));
		return resource;

	}

}
