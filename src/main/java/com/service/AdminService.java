package com.service;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.AdminNotFoundException;
import com.advices.ResourceNotFoundException;
import com.model.Admin;
import com.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;

//implementation methods

	public Admin addAdmin(Admin c) {
		adminRepo.save(c);
		return c;
	}

	public List<Admin> getAdmins() {
		List<Admin> lc1 = adminRepo.findAll();

		return lc1;
	}

	public Admin getAdminById(int cid) throws Throwable {
		Supplier s1 = () -> new ResourceNotFoundException("Admin Does not exist in the database");
		Admin c = adminRepo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteAdminById(int cid) {

		adminRepo.deleteById(cid);

		return "Deleted";
	}

	public Admin updateAdmin(int Id, Admin admin) throws AdminNotFoundException {

		Integer getId = Integer.valueOf(Id);

		if (getId instanceof Integer) {
			Optional<Admin> optional = adminRepo.findById(getId);

			if (optional.isPresent()) {
				Admin gotAdmin = optional.get();
				gotAdmin.setUsername(admin.getUsername());
				gotAdmin.setPassword(admin.getPassword());
				gotAdmin.setEmail(admin.getEmail());

				Admin updateAdmin = adminRepo.save(gotAdmin);
				return updateAdmin;
			}

			else {
				throw new AdminNotFoundException("Given admin id is not present in the database.");
			}
		} else {
			throw new AdminNotFoundException("The ID should be a number type");
		}

	}

	public List<Admin> addAdmins(List<Admin> ls) {
		adminRepo.saveAll(ls);
		return ls;
	}
	
public Admin validateAdmin(String username, String password, String role) throws NullPointerException, NumberFormatException, InputMismatchException, AdminNotFoundException {
		
		
		if(role.equalsIgnoreCase("Admin")){
			if(username!=null) {
				if(password!=null) {
					Admin validAdmin = adminRepo.findByUsernameAndPassword(username, password);
					if(validAdmin != null) {
						return validAdmin;
					}
					else {
						throw new AdminNotFoundException("Username or password is not exist. please try again.");
					}
				}
				else {
					throw new AdminNotFoundException("Please provide the password.");
				}
			}
			else {
				throw new AdminNotFoundException("Please provide the username.");
			}
		}
		else {
			throw new AdminNotFoundException("Given Admin is not present.");
		}
		
	}

}