package com.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.AdminNotFoundException;
import com.dto.AdminDto;
import com.dto.AdminInputDto;
import com.model.Admin;
import com.model.Login;
import com.repository.AdminRepository;
import com.repository.LoginRepository;



@Service
public class AdminService  {

	@Autowired
	AdminRepository adminDao;
	
	
	@Autowired
	LoginRepository loginDao;
	
	private static Logger logger = LogManager.getLogger();
	
	
	public List<Admin> getAllAdmins() {
		return adminDao.findAll();
	}

	
	public AdminDto getAdminById(int id) throws AdminNotFoundException {
		Optional<Admin> admin = adminDao.findById(id);
		if(!admin.isPresent()) {
			throw new AdminNotFoundException("Admin not found with given id "+id);
		}
		
		Admin std = admin.get();
		
		// Create dto obj
		AdminDto dto = new AdminDto();
		
		// update dto with admin details
		dto.setAdminId(std.getAdminId());
		dto.setFullName(std.getFullName());
		dto.setContactNo(std.getContactNo());
		dto.setEmail(std.getLogin().getEmail());
		dto.setRole(std.getLogin().getRole());
		dto.setLoginId(std.getLogin().getLoginId());
		return dto;
	}

	public Admin addAdmin(AdminInputDto admin) {
		
		Admin std = new Admin();
		
		// convert admindto obj to admin obj
		
		std.setContactNo(admin.getContactNo());
		std.setFullName(admin.getFullName());
		
		Login login = new Login();
		login.setEmail(admin.getEmail());
		login.setRole(admin.getRole());
		login.setPassword(admin.getPassword());
		
		std.setLogin(login);
				
		return adminDao.save(std);
	}

	
	public Admin updateAdmin(int rollNo, AdminDto admin) throws AdminNotFoundException {
		
		Optional<Admin> optional = adminDao.findById(rollNo);
		if(!optional.isPresent()) {
			throw new AdminNotFoundException("Admin not found with given rollNo "+rollNo);
		}
		Admin std = optional.get();
		
		std.setFullName(admin.getFullName());
		std.setContactNo(admin.getContactNo());
	
		Login login = loginDao.findById(admin.getLoginId()).get();
		
	    login.setEmail(admin.getEmail());
	    login.setRole(admin.getRole());
	    
		std.setLogin(login);
		return adminDao.save(std);
	}

	
	public Admin deleteAdminById(int rollNo) {
		Admin std = adminDao.findById(rollNo).get();
		adminDao.deleteById(rollNo);
		return std;
	}

	
	public Admin updateAdminName(int rollNo, String newName) {
		Admin std = adminDao.findById(rollNo).get();
		std.setFullName(newName);
		return adminDao.save(std);
	}

	
	public Admin getAdminByName(String fullName) {
		Admin admin = adminDao.findByFullName(fullName);
		return admin;
	}

	
	public void deleteAdminByName(String fullName) {
		adminDao.deleteByName(fullName);
		
	}

	

}