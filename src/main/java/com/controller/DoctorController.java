package com.controller;

import java.util.InputMismatchException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advices.DoctorNotFoundException;
import com.model.Doctor;
import com.service.DoctorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorservice;
	
	@RequestMapping("/Hello")
	public String HelloDoctor()
	{
		String msg="Welcome to Doctor Home Page";
		return msg;
	}
	
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor c)
	{
		Doctor c1=doctorservice.addDoctor(c);
		ResponseEntity re=new ResponseEntity<Doctor>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getDoctors()
	{
		List<Doctor> lc1=doctorservice.getDoctors();
		ResponseEntity re=new ResponseEntity<List<Doctor>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/doctors/{id}")
	public ResponseEntity<Doctor> getEmpById(@PathVariable int id) throws Throwable
	{
		Doctor c1=doctorservice.getDoctorById(id);		
		ResponseEntity re=new ResponseEntity<Doctor>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addDoctors")
	public ResponseEntity<List<Doctor>> addDoctors(@RequestBody List<Doctor> ls)
	{
		List<Doctor> le=doctorservice.addDoctors(ls);	
		ResponseEntity re=new ResponseEntity<List<Doctor>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/doctors/{doctorId}")
	public ResponseEntity<?> updateDoctor(@PathVariable int doctorId, @RequestBody Doctor doctor) throws DoctorNotFoundException {
		Doctor updatedDoctor = doctorservice.updateDoctor(doctorId, doctor);
		return new ResponseEntity<Doctor>(updatedDoctor, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/doctors/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable int id) throws InputMismatchException, DoctorNotFoundException
	{
		doctorservice.deleteDoctorById(id);		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
/*	
	@PostMapping("/login")
	public ResponseEntity<?> validateDoctor(@RequestBody Doctor customer) throws DoctorNotFoundException {
		Doctor validDoctor = doctorservice.validateDoctor(customer);
		return new ResponseEntity<Doctor>(validDoctor,HttpStatus.OK);
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<?> logout(@RequestBody String username) throws DoctorNotFoundException{
		Doctor loggedInDoctor = doctorservice.logout(username);
		return new ResponseEntity<Doctor>(loggedInDoctor, HttpStatus.OK);
	}
	*/
	

}