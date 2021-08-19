package com.management.personacovid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.personacovid.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{}
