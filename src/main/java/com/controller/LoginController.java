package com.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LoginDto;
import com.advices.InvalidCredentialsException;
import com.model.Login;
import com.service.LoginService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/login")
	public ResponseEntity<LoginDto> login(@RequestBody Login login) throws InvalidCredentialsException {
		LoginDto dto = loginService.login(login);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@PatchMapping("/logout/{username}")
	public ResponseEntity<LoginDto> logout(@PathVariable("username") String username) throws InvalidCredentialsException  {
		logger.info(username);
		LoginDto dto = loginService.logout(username);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	

}