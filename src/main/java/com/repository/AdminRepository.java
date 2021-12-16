package com.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	// Custom methods
		Admin findByFullName(String fullName);
		//Student findByAge(int age);
		
		// JPQL Query methods
		//@Query("delete from Student s where s.fullName=:name")
		//Student deleteStudentByName(@Param("name") String fullName);
		
		// Native Query method
		@Query(value="delete from admin where fullname=:name", nativeQuery=true)
		void deleteByName(@Param("name") String fullName);
}
