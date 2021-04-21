package com.hardik.lattice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.lattice.dto.PatientDto;
import com.hardik.lattice.request.PatientCreationRequest;
import com.hardik.lattice.request.PatientUpdationRequest;
import com.hardik.lattice.service.PatientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PatientController {

	private final PatientService patientService;

	@GetMapping("v1/patients")
	public List<PatientDto> retreiveAllPatients() {
		return patientService.retreiveAllPatients();
	}

	@GetMapping("v1/patient/{patientId}")
	public PatientDto retreivePatientHandler(@PathVariable(name = "patientId") final UUID patientId) {
		return patientService.retreivePatient(patientId);
	}

	@PostMapping("v1/patient")
	public UUID patientCreationHandler(
			@RequestBody(required = true) final PatientCreationRequest patientCreationRequest) {
		return patientService.createPatient(patientCreationRequest);
	}

	@PutMapping("v1/patient")
	public PatientDto patientCreationHandler(
			@RequestBody(required = true) final PatientUpdationRequest patientUpdationRequest) {
		return patientService.updatePatient(patientUpdationRequest);
	}

	@DeleteMapping("v1/patient/{patientId}")
	public void patientDeletionHandler(@PathVariable(name = "patientId") final UUID patientId) {
		patientService.deletePatient(patientId);
	}

}
