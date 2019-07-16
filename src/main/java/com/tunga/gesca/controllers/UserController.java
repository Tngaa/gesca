package com.tunga.gesca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunga.gesca.entities.User;
import com.tunga.gesca.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")

public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getUsers() {
		
		return (List<User>)userRepository.findAll();
	}
}
