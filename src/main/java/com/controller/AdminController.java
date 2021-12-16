package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advices.AdminNotFoundException;
import com.dto.AdminDto;
import com.dto.AdminInputDto;
import com.model.Admin;
import com.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	private static Logger logger = LogManager.getLogger();
	
	// Get all admins - GET
	// Get - /admins
	@GetMapping("/admins")
	ResponseEntity<List<Admin>> getAllAdmins() {
		logger.info("Sending request to service layer for getting studends");
		return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK); // 200 Ok
	}

	// Get admin by id - GET
	@GetMapping("/admins/id/{id}")
	ResponseEntity<AdminDto> getAdminById(@PathVariable("id") int id) throws AdminNotFoundException {
	 logger.info("Sending request to service layer to get admin by id");
	 AdminDto admin = adminService.getAdminById(id);
	 logger.debug("Received admin object from service layer");
	 logger.info("Returning admin object");
	 return new ResponseEntity<>(admin, HttpStatus.OK); // 200 Ok
		
	}
	
	// Get admin by Name - GET
	@GetMapping("/admins/name/{stdName}")
	ResponseEntity<Admin> getAdminByName(@PathVariable("stdName") String fullName) {
		Admin admin = adminService.getAdminByName(fullName);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	// Add new admin - POST
	@PostMapping("/admins")
	ResponseEntity<Admin> addAdmin(@Valid @RequestBody AdminInputDto admin) {
		logger.info(admin);
		Admin std = adminService.addAdmin(admin);
		return new ResponseEntity<>(std, HttpStatus.CREATED); // 201 created
	}
	
	// Delete admin by roll number - DELETE
	@DeleteMapping("/admins/{id}")
	ResponseEntity<Admin> deleteAdminById(@PathVariable("id") int id) {
		Admin admin= adminService.deleteAdminById(id);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@DeleteMapping("/admins/delete/{fullName}")
	ResponseEntity<Void> deleteAdmin(@PathVariable("fullName") String fullName) {
		adminService.deleteAdminByName(fullName);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	// Update admin - PUT
	@PutMapping("/admins/{id}")
	ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id, @RequestBody AdminDto admin) throws AdminNotFoundException {
	 Admin std = adminService.updateAdmin(id, admin);
	 return new ResponseEntity<>(std, HttpStatus.OK);
	}

	// update admin name - PATCH
	@PatchMapping("/admins/{id}")
	ResponseEntity<Admin> updateAdminName(@PathVariable("id") int id, @RequestBody String newName) {
		Admin admin = adminService.updateAdminName(id, newName);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}

	/*
	// update admin age -  PATCH
	Admin updateAdminAge(int id, int newAge) {}
	
	*/
	
	

}