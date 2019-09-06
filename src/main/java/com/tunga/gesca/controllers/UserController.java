package com.tunga.gesca.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunga.gesca.entities.AnnualSale;
import com.tunga.gesca.entities.User;
import com.tunga.gesca.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")

public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getUsers() {

		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable Integer userId) {
		User user = null;

		Optional<User> optUser = userRepository.findById(userId);

		if (optUser.isPresent()) {
			user = optUser.get();

			List<AnnualSale> sortedAnnualSales = user.getAnnualSales().stream()
					.sorted(Comparator.comparingInt(AnnualSale::getYear).reversed()).collect(Collectors.toList());
			user.setAnnualSales(sortedAnnualSales);
		}

		return user;
	}
}
