package com.controller;

import java.util.List;

import javax.validation.Valid;

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


import com.model.Finance;
import com.service.FinanceService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/hsm")
public class FinanceController {
	
	@Autowired
	FinanceService financeService;
	
	@GetMapping("/getBills")
	public ResponseEntity<List<Finance>> getBills()
	{
		List<Finance> f1=financeService.getBills();
		ResponseEntity re=new ResponseEntity<List<Finance>>(f1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/addBill")
	public ResponseEntity<Finance> addBill(@RequestBody Finance f){
		Finance f1=financeService.addBill(f);
		ResponseEntity re = new ResponseEntity<Finance>(f,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addBills")
	public ResponseEntity<List<Finance>> addBills(@RequestBody List<Finance> fs)
	{
		List<Finance> fe=financeService.addBills(fs);
		
		ResponseEntity re=new ResponseEntity<List<Finance>>(fe,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getBill/{bId}")
	public ResponseEntity<Finance> getBill(@PathVariable int bId) throws Throwable{
		Finance f3=financeService.getBillById(bId);
		ResponseEntity<Finance> re1=new ResponseEntity<Finance>(f3,HttpStatus.OK);
		return re1;
	}
	
	@DeleteMapping(path="/deleteBill/{bId}")
	public ResponseEntity<String> deleteBillById( @PathVariable int bId)
	{
		financeService.deleteBillById(bId);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted Bill with Bill No : "+bId,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteBills")
	public ResponseEntity<String> deleteBill(@RequestBody Finance f)
	{
		financeService.deleteBill(f);
		ResponseEntity re=new ResponseEntity<String>("Bill Deleted",HttpStatus.OK);
		return re;
	}  
	@PutMapping(path="/updateBill")
	public ResponseEntity<Finance> updateBill(@RequestBody Finance f) throws Throwable
	{
		Finance f1=financeService.updateBill(f);
		ResponseEntity re=new ResponseEntity<Finance>(f1,HttpStatus.OK);
		return re;
	}

}