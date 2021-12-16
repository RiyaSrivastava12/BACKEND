package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
	
//	@Query("select c from Customer c where c.username=:user and c.password=:pass")
//	public Optional<Customer> findByUsernameAndPassword(@Param("user") String username, @Param("pass") String Password);
	
//	@Query(value="select * from user_details where username=:name", nativeQuery=true )
//	public Optional<Doctor> findByUsername(String username);


}