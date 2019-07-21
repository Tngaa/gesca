package com.tunga.gesca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tunga.gesca.entities.AnnualSale;

public interface AnnualSaleRepository extends CrudRepository< AnnualSale, Integer> {
	public List<AnnualSale> findByUserId(Integer userId);
	
	@Query("SELECT asl FROM AnnualSale asl WHERE asl.id = :id AND asl.user.id = :userId")
	public AnnualSale findByIdAndUserId(@Param("id") Integer id, @Param("userId") Integer userId);
	
//	public AnnualSale findByIdAndUserId(Integer id, Integer userId);
	
//	@Query("DELETE FROM AnnualSale WHERE id = :id AND user.id = :userId")
//	public void deleteByUser();
	
	public void deleteByIdAndUserId(Integer id, Integer userId);
}
