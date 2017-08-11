package com.codingdojo.GroupLanguagesData.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.GroupLanguagesData.models.Language;


@Service

public class LanguageService {

	private List<Language> languages = new ArrayList<>();
	
	public List<Language> allLanguages(){
		return languages;
	} 
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public Language find(int index) {
		if (index < languages.size()) {
			return languages.get((index));
		}else {
			return null;
		}
	}
	
	public void update(int id, Language language) {
		if (id < languages.size()) {
			languages.set(id, language);
		}
	}
	
	public void delete(int id) {
		if (id < languages.size()) {
			languages.remove(id);
		}
	}
	

}
