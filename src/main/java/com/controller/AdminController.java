package com.controller;

import java.util.InputMismatchException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advices.AdminNotFoundException;
import com.model.Admin;
import com.service.AdminService;
import com.service.AdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin c)
	{
		Admin c1=adminservice.addAdmin(c);
		ResponseEntity re=new ResponseEntity<Admin>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins()
	{
		List<Admin> lc1=adminservice.getAdmins();
		ResponseEntity re=new ResponseEntity<List<Admin>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/admins/{id}")
	public ResponseEntity<Admin> getEmpById(@PathVariable int id) throws Throwable
	{
		Admin c1=adminservice.getAdminById(id);		
		ResponseEntity re=new ResponseEntity<Admin>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addAdmins")
	public ResponseEntity<List<Admin>> addAdmins(@RequestBody List<Admin> ls)
	{
		List<Admin> le=adminservice.addAdmins(ls);	
		ResponseEntity re=new ResponseEntity<List<Admin>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/admins/{adminId}")
	public ResponseEntity<?> updateAdmin(@PathVariable int adminId, @RequestBody Admin admin) throws AdminNotFoundException {
		Admin updatedAdmin = adminservice.updateAdmin(adminId, admin);
		return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/admins/{id}")
	public ResponseEntity<String> deleteAdminById(@PathVariable int id) throws InputMismatchException, AdminNotFoundException
	{
		adminservice.deleteAdminById(id);		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/validateAdmin")
	public ResponseEntity<?> validateAdmin(@RequestParam("user") String username, @RequestParam("pass") String password, @RequestParam("role") String role) throws NumberFormatException, InputMismatchException, NullPointerException, AdminNotFoundException {
		Admin validAdmin = adminservice.validateAdmin(username, password, role);
		return new ResponseEntity<Admin>(validAdmin,HttpStatus.OK);
	}
	
	

}