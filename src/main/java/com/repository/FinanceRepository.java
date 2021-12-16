package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Finance;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Integer>
{
	
	

}