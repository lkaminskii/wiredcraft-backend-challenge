package com.wired.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wired.api.model.User;
import com.wired.api.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User insert(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User user) {
		User newUser = userService.update(id, user);
		return ResponseEntity.ok().body(newUser);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteUserById (@PathVariable Long id) throws Exception {
		userService.deleteById(id);
	}

}
