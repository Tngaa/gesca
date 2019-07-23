package com.tunga.gesca.controllers;

import java.util.List;

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
import com.tunga.gesca.entities.MonthlySale;
import com.tunga.gesca.repositories.AnnualSaleRepository;
import com.tunga.gesca.repositories.MonthlySaleRepository;

@RestController
@RequestMapping(value = "/users")
public class MonthlySaleController {
	@Autowired
	private MonthlySaleRepository monthlySaleRepository;

	@Autowired
	private AnnualSaleRepository annualSaleRepository;
//	
//	@Autowired 
//	private UserRepository userRepository;	
	


	@GetMapping("/{userId}/annual-sales/{annualSaleId}/monthly-sales")
	public List<MonthlySale> getMonthlySales(@PathVariable Integer userId, @PathVariable Integer annualSaleId) {

		return monthlySaleRepository.findByAnnualIdAndUserId(annualSaleId, userId);
	}

	@PostMapping("/{userId}/annual-sales/{annualSaleId}/monthly-sales")
	public MonthlySale createMonthlySale(@PathVariable Integer userId, @PathVariable Integer annualSaleId, @RequestBody MonthlySale monthlySale) {

		AnnualSale annualSale = annualSaleRepository.findByIdAndUserId(annualSaleId, userId);
		
		monthlySale.setAnnualSale(annualSale);
		
		return monthlySaleRepository.save(monthlySale);
	}

	@PutMapping("/{userId}/annual-sales/{annualSaleId}/monthly-sales/{monthlySaleId}")
	public MonthlySale updateMonthlySale(@PathVariable Integer userId, @PathVariable Integer annualSaleId, @PathVariable Integer monthlySaleId, @RequestBody MonthlySale monthlySale) {

		//		exMonthlySale l'objet existent en base de donnees
		 
		MonthlySale exMonthlySale = monthlySaleRepository.findBySpecificMonthlySale(annualSaleId, userId, monthlySaleId);
		
		
		exMonthlySale.setMonth(monthlySale.getMonth());
		
		return monthlySaleRepository.save(exMonthlySale);
		
	}
	
	@Transactional
	@DeleteMapping("/{userId}/annual-sales/{annualSaleId}/monthly-sales/{monthlySaleId}")
	public void deleteMonthlySale(@PathVariable Integer userId, @PathVariable Integer annualSaleId, @PathVariable Integer monthlySaleId) {
		MonthlySale exMonthlySale = monthlySaleRepository.findBySpecificMonthlySale(annualSaleId, userId, monthlySaleId);
		monthlySaleRepository.delete(exMonthlySale);
	}
}
