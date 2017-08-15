package com.coding.DojosNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.DojosNinjas.models.Dojo;
import com.coding.DojosNinjas.repositories.DojoRepository;


@Service
public class DojoService {
	
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public void createDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	

	public Dojo findOneDojo(Long id) {
		return dojoRepository.findOne(id);
	}

	public List<Dojo> findDojos() {
		return (List<Dojo>) dojoRepository.findAll();
	}


	
	



}
