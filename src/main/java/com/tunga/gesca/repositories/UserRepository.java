package com.tunga.gesca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tunga.gesca.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("FROM User WHERE id = :userId")
	public Optional<User> findById(@Param("userId") Integer userId);
}
