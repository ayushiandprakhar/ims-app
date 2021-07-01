package com.fis.ims.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ims")
public class WelcomController {

	@Value("${spring.application.name:IMS Application}")
	private String appName;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return "Welcome user to "+appName;
	}
}
