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

import com.advices.ResourceNotFoundException;
import com.model.HealthInsurancePolicy;
import com.model.PatientPersonalDetails;
import com.service.PatientPersonalDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientPersonalDetailsController {
	@Autowired
	PatientPersonalDetailsService patientService;

	// add patient
	@PostMapping("/PatientPersonalDetails/add") 
	ResponseEntity<PatientPersonalDetails> addPatientPersonalDetails(@RequestBody PatientPersonalDetails patient) {
		PatientPersonalDetails patient2 = patientService.addPatientPersonalDetails(patient);
		return new ResponseEntity<>(patient2, HttpStatus.CREATED);// 201 created
	}

	// get patient by id
	@GetMapping("/PatientPersonalDetails/{pId}")
	ResponseEntity<PatientPersonalDetails> getPatientPersonalDetailsById(@PathVariable("pId") int pId) {
		PatientPersonalDetails patient3 = patientService.getPatientPersonalDetailsById(pId);
		return new ResponseEntity<>(patient3, HttpStatus.OK); // 200 ok

	}

	
	 //update patient
	 
	  /*@PutMapping("/PatientPersonalDetails/{pId}")
	  ResponseEntity<PatientPersonalDetails>
	  updatePatientPersonalDetails(@PathVariable("pId") int pId, @RequestBody
	  PatientPersonalDetails patient) {
	  patientService.updatePatientPersonalDetails(pId,patient); return new
	  ResponseEntity<>(patient,HttpStatus.OK); }
	 */

	/*@PutMapping(path = "/updatePatientPersonalDetails")
	ResponseEntity<PatientPersonalDetails> updatePatientPersonalDetails(@RequestBody PatientPersonalDetails e)
			throws Throwable {
		PatientPersonalDetails e1 = patientService.updatePatientPersonalDetails(e);

		ResponseEntity re = new ResponseEntity<PatientPersonalDetails>(e1, HttpStatus.OK);
		return re;
	}*/
	
	@PutMapping("/PatientPersonalDetails/{pId}")
	public ResponseEntity<?> updatePatientPersonalDetails(@PathVariable int pId, @RequestBody  PatientPersonalDetails e) throws ResourceNotFoundException {
		PatientPersonalDetails e1 = patientService.updatePatientPersonalDetails(pId, e);
		return new ResponseEntity<PatientPersonalDetails >(e1, HttpStatus.OK);
	}

	// get all patients
	@GetMapping("/PatientPersonalDetails")
	ResponseEntity<List<PatientPersonalDetails>> getAllPatientPersonalDetails() {
		List<PatientPersonalDetails> patient3 = patientService.getAllPatientPersonalDetails();
		return new ResponseEntity<>(patient3, HttpStatus.OK); // 200 ok

	}

	// delete patient by id
	@DeleteMapping("/PatientPersonalDetails/{Id}")
	ResponseEntity<PatientPersonalDetails> deleteEmployeeById(@PathVariable("Id") int pId) {
		PatientPersonalDetails patient = patientService.deletePatientPersonalDetailsById(pId);
		return new ResponseEntity<>(patient, HttpStatus.OK);

	}
}