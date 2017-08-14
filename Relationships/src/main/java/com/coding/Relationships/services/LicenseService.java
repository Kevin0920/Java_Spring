package com.coding.Relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.Relationships.models.License;

import com.coding.Relationships.repositories.LicenseRepository;


@Service
public class LicenseService {
	
	private LicenseRepository licenseRepository;
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses() {
		return (List<License>) licenseRepository.findAll();
	}

	public void createLicense(License license) {
		licenseRepository.save(license);
	}

	public License findLicense(Long person_id) {
		return licenseRepository.findOneByPersonId(person_id);
	}

	public License getLicense(Long id) {
		return licenseRepository.findOne(id);
	}
	
	
	

}
