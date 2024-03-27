package com.sreenu.online.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sreenu.online.ecommerce.model.UserRegistrationModel;

public interface UserRegistrationRepository extends JpaRepository<UserRegistrationModel, Integer> {

}
