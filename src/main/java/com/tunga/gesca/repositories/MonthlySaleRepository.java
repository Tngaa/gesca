package com.tunga.gesca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tunga.gesca.entities.MonthlySale;

public interface MonthlySaleRepository extends CrudRepository< MonthlySale, Integer> {
	
	@Query("SELECT ms FROM MonthlySale ms WHERE ms.annualSale.id = :annualSaleId AND ms.annualSale.user.id = :userId")
	public List<MonthlySale> findByAnnualIdAndUserId(@Param("annualSaleId") Integer annualSaleId, @Param("userId") Integer userId);

	@Query("SELECT ms FROM MonthlySale ms WHERE ms.annualSale.id = :annualSaleId AND ms.annualSale.user.id = :userId AND ms.id = :monthlySaleId")
	public MonthlySale findBySpecificMonthlySale(@Param("annualSaleId") Integer annualSaleId, @Param("userId") Integer userId, @Param("monthlySaleId") Integer monthlySaleId);
}
