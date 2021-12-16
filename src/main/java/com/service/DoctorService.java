package com.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.DoctorNotFoundException;
import com.advices.ResourceNotFoundException;
import com.model.Doctor;
import com.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository repo;

	//Adding a single object
	public Doctor addDoctor(Doctor c) {
		repo.save(c);
		return c;
	}

	//Getting a list of object
	public List<Doctor> getDoctors() {
		List<Doctor> lc1 = repo.findAll();

		return lc1;
	}

	//Getting single object
	public Doctor getDoctorById(int cid) throws Throwable {
		Supplier s1 = () -> new DoctorNotFoundException("Doctor Does not exist in the database");
		Doctor c = repo.findById(cid).orElseThrow(s1);
		return c;
	}

	// deleting a single object by id
	public Doctor deleteDoctorById(int doctorId) throws InputMismatchException, DoctorNotFoundException,NumberFormatException {
		
		Integer id = Integer.valueOf(doctorId);

		if (id instanceof Integer) {
			Optional<Doctor> optional = repo.findById(doctorId);

			if (optional.isPresent()) {
				Doctor gotDoctor = optional.get();
				repo.delete(gotDoctor);
				return gotDoctor;
			}

			else {
				throw new DoctorNotFoundException("Given doctor id is not present in the database");
			}
		} else {
			throw new InputMismatchException("Given Id should be a number");
		}
	}
	
	// updating a single object
	public Doctor updateDoctor(int Id, Doctor doctor) throws DoctorNotFoundException {

		Integer getId = Integer.valueOf(Id);
		if (getId instanceof Integer) {
			Optional<Doctor> optional = repo.findById(getId);

			if (optional.isPresent()) {
				Doctor gotDoctor = optional.get();
				gotDoctor.setDname(doctor.getDname());
				gotDoctor.setQualification(doctor.getQualification());
				gotDoctor.setSpecialization(doctor.getSpecialization());
				gotDoctor.setAvailability(doctor.getAvailability());

				Doctor updateDoctor = repo.save(gotDoctor);
				return updateDoctor;
			}

			else {
				throw new DoctorNotFoundException("Given Doctor id is not present in the database.");
			}
		} else {
			throw new DoctorNotFoundException("The ID should be a number type");
		}

	}

	public List<Doctor> addDoctors(List<Doctor> ls) {
		repo.saveAll(ls);
		return ls;
	}
	/*
	public Doctor validateDoctor(Doctor doctor)
			throws DoctorNotFoundException {


		Optional<Doctor> optional = repo.findByUsername(doctor.getUsername());
		System.out.println(optional);
		if (optional.isPresent()) {
			Doctor validDoctor = optional.get();
			if (doctor.getUsername().equalsIgnoreCase(validDoctor.getUsername())
					&& (doctor.getPassword().equalsIgnoreCase(validDoctor.getPassword()))
					&& (doctor.getRole().equalsIgnoreCase(validDoctor.getRole()))) {
				validDoctor.setLoggedIn(true);
				
				// update isLoggedIn flag to true
			repo.save(validDoctor);
				return validDoctor;
			}
			else {
				throw new DoctorNotFoundException("Given username or password is wrong.");
			}
		}
		 else {
			throw new DoctorNotFoundException("Given username or password not exist");
		}
	}

	public Doctor logout(String username) throws DoctorNotFoundException {
		
		Optional<Doctor> optional = repo.findByUsername(username);
		if(!(optional.isPresent())) {
			throw new DoctorNotFoundException("Invalid username");
		}
		
		Doctor getDoctor = optional.get();
		getDoctor.setLoggedIn(false);
		repo.save(getDoctor);
		return getDoctor;
	}
*/
}

