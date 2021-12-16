package com.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.model.HealthInsurancePolicy;
import com.service.HealthInsurancePolicyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api")
public class HealthInsurancePolicyController {
	
	@Autowired
	HealthInsurancePolicyService policyservice;
	
	
	@PostMapping("/addPolicy")
	public ResponseEntity<HealthInsurancePolicy> addHealthInsurancePolicy(@RequestBody HealthInsurancePolicy d)
	{
		HealthInsurancePolicy c1=policyservice.addHealthInsurancePolicy(d);
		ResponseEntity re=new ResponseEntity<HealthInsurancePolicy>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getAllPolicy")
	public ResponseEntity<List<HealthInsurancePolicy>> getHealthInsurancePolicys()
	{
		List<HealthInsurancePolicy> lc1=policyservice.getHealthInsurancePolicys();
		ResponseEntity re=new ResponseEntity<List<HealthInsurancePolicy>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getPolicy/{did}")
	public ResponseEntity<HealthInsurancePolicy> getHealthInsurancePolicyById(@PathVariable int did) throws Throwable
	{
		HealthInsurancePolicy c1=policyservice.getHealthInsurancePolicyById(did);
		
		ResponseEntity re=new ResponseEntity<HealthInsurancePolicy>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addAllPolicy")
	public ResponseEntity<List<HealthInsurancePolicy>> addHealthInsurancePolicys(@RequestBody List<HealthInsurancePolicy> ls)
	{
		List<HealthInsurancePolicy> le=policyservice.addHealthInsurancePolicys(ls);
		
		ResponseEntity re=new ResponseEntity<List<HealthInsurancePolicy>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updatePolicy")
	public ResponseEntity<HealthInsurancePolicy> updateHealthInsurancePolicy(@RequestBody HealthInsurancePolicy e) throws Throwable
	{
		HealthInsurancePolicy e1=policyservice.updateHealthInsurancePolicy(e);
		
		ResponseEntity re=new ResponseEntity<HealthInsurancePolicy>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deletePolicy")
	public ResponseEntity<String> deleteHealthInsurancePolicy(@RequestBody HealthInsurancePolicy e)
	{
		policyservice.deleteHealthInsurancePolicy(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deletePolicy/{eid}")
	public ResponseEntity<String> deleteHealthInsurancePolicyById(@PathVariable int eid)
	{
		policyservice.deleteHealthInsurancePolicyById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	

}