package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.HealthInsurancePolicy;
import com.repository.HealthInsurancePolicyRepository;


@Service
public class HealthInsurancePolicyService {
	
	@Autowired
	HealthInsurancePolicyRepository repo;
	
	public HealthInsurancePolicy addHealthInsurancePolicy(HealthInsurancePolicy c)
	{
		 repo.save(c);	
		 return c;
	}
	
	public List<HealthInsurancePolicy> getHealthInsurancePolicys()
	{
		List<HealthInsurancePolicy> lc1=repo.findAll();
		
		return lc1;
	}

	public HealthInsurancePolicy getHealthInsurancePolicyById(int cid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("HealthInsurancePolicy Does not exist in the database");
		HealthInsurancePolicy c=repo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteHealthInsurancePolicyById(int cid) {
		
		repo.deleteById(cid);
		
		return "Deleted";
	}

	public String deleteHealthInsurancePolicy(HealthInsurancePolicy c) {
		
		repo.delete(c);
		return "Deleted";
	}

	public HealthInsurancePolicy updateHealthInsurancePolicy(HealthInsurancePolicy c) throws Throwable {
		int id=c.getpNum();
		
		Supplier s1= ()->new ResourceNotFoundException("HealthInsurancePolicy Does not exist in the database");
		HealthInsurancePolicy c1=repo.findById(id).orElseThrow(s1);
		
		c1.setpNum(c.getpNum());
		c1.setpName(c.getpName());
		c1.setpTerm(c.getpTerm());
		
			repo.save(c1);
			return c1;	
	}

	public List<HealthInsurancePolicy> addHealthInsurancePolicys(List<HealthInsurancePolicy> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}
