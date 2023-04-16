package com.kpts.vanshawali.controller;

import java.util.List;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpts.vanshawali.models.Vyakti;
import com.kpts.vanshawali.service.ServiceData;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerClass {
	
	@Autowired
	ServiceData service;
	
	public ControllerClass(ServiceData service) {
	
		this.service = service;
	}

	@RequestMapping("/")
    public String home() {
            return "Hello working apis from render!";
    }
	
	@GetMapping("/adminLogin")
	public boolean adminLoginCheck(@RequestParam String userId, String password) {

		return service.adminLogin(userId, password);
	}
	
	@GetMapping("/getEveryone")
	public List<Vyakti> getEntireVanshawali()
	{
		return service.getEntireVanshawali();
	}
	@PostMapping("/addVyakti")
	public boolean addVyakti(@RequestBody String vyaktiDetails)
	{
		log.info(vyaktiDetails);
		
		Vyakti vyakti;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			vyakti = mapper.readValue(vyaktiDetails, Vyakti.class);
			log.info(vyakti.toString());
			return service.addVyakti(vyakti);
		} catch (Exception e) {
			log.info("Nahi hua convert");
			return false;
		}
		
		
	}
	
	@PostMapping("/updateVyakti")
	public boolean updateVyakti(@RequestParam String id,@RequestBody String vyaktiDetails) {
		
		log.info(vyaktiDetails);
		
		Vyakti vyakti;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			vyakti = mapper.readValue(vyaktiDetails, Vyakti.class);
			log.info(vyakti.toString());
			return service.updateVyakti(id,vyakti);
		} catch (Exception e) {
			log.info("Nahi hua convert");
			return false;
		}
		
	}
	//Till delete
	@DeleteMapping("/removeVyakti")
	public boolean removeVyakti(@RequestParam String id)
	{
		return service.removeVyakti(id);
	}

}
