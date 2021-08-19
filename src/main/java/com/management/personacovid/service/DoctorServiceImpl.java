/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.management.personacovid.service;

import com.management.personacovid.model.Doctor;
import com.management.personacovid.repository.DoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author Encryptor_95 */
@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository docrepo;

	@Override
	public List<Doctor> getAllDoctor() {
		return docrepo.findAll();
	}
}
