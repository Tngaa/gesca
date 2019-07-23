package com.tunga.gesca.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunga.gesca.entities.AnnualSale;
import com.tunga.gesca.entities.User;
import com.tunga.gesca.repositories.AnnualSaleRepository;
import com.tunga.gesca.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class AnnualSaleController {
	@Autowired
	private AnnualSaleRepository annualSaleRepository;

	@Autowired
	private UserRepository userRepository;	

	@GetMapping("/{userId}/annual-sales")
	public List<AnnualSale> getAnnualSales(@PathVariable Integer userId) {

		return annualSaleRepository.findByUserId(userId);
	}

	@PostMapping("/{userId}/annual-sales")
	public AnnualSale createAnnualSale(@PathVariable Integer userId, @RequestBody AnnualSale annualSale) throws Exception {
		
		Optional<User> optUser = userRepository.findById(userId);
		if (!optUser.isPresent()) {
			throw new Exception("User not exists by id " + userId);
		}
		
		User user = optUser.get();
		annualSale.setUser(user);
		AnnualSale exAnnualSale = annualSaleRepository.save(annualSale);

		return exAnnualSale;

	}
	
	@PutMapping("/{userId}/annual-sales/{annualSaleId}")
	public AnnualSale updateAnnualSale(@PathVariable Integer userId, @PathVariable Integer annualSaleId, @RequestBody AnnualSale annualSale) {
		
		AnnualSale exAnnualSale = annualSaleRepository.findByIdAndUserId(annualSaleId, userId);
		
		// Inderdit -> exAnnaulSale.setId(annualSale.getId());
		exAnnualSale.setYear(annualSale.getYear());
		
		return annualSaleRepository.save(exAnnualSale);
		
	}
	
	@Transactional
	@DeleteMapping("/{userId}/annual-sales/{annualSaleId}")
	public void deleteAnnualSale(@PathVariable Integer userId, @PathVariable Integer annualSaleId) {
		annualSaleRepository.deleteByIdAndUserId(annualSaleId, userId);
	}
}
