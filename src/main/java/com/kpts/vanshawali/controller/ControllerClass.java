package com.kpts.vanshawali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
