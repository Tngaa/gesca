package com.tunga.gesca.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tunga.gesca.entities.User;

public interface UserRepository extends CrudRepository< User, Integer> {

}
