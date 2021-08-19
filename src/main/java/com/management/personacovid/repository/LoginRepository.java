package com.management.personacovid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.personacovid.model.LoginDetails;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails, Long> {

	public LoginDetails findByEmail(String username);

}
