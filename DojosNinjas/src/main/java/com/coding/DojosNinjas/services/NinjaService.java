package com.coding.DojosNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.coding.DojosNinjas.models.Ninja;
import com.coding.DojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public void createNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}


	public List<Ninja> dojoNinja(){
		return (List<Ninja>) ninjaRepository.findAll();
	}
	
}
