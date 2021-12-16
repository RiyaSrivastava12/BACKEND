package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Login;

@Repository
public interface LoginRepository extends JpaRepositoryImplementation<Login, Integer> {

	Optional<Login> findByEmail(String email);

	@Query(value="select * from login where user_id=:name", nativeQuery=true )
	Optional<Login> findByUsrName(@Param("name") String name);

}