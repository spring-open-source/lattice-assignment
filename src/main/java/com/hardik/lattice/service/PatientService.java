package com.hardik.lattice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hardik.lattice.dto.PatientDto;
import com.hardik.lattice.entity.Patient;
import com.hardik.lattice.repository.PatientRepository;
import com.hardik.lattice.request.PatientCreationRequest;
import com.hardik.lattice.request.PatientUpdationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {

	private final PatientRepository patientRepository;

	public PatientDto retreivePatient(final UUID patientId) {
		final var patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new RuntimeException("INVALID PATIENT ID"));
		return PatientDto.builder().id(patient.getId()).address(patient.getAddress()).createdAt(patient.getCreatedAt())
				.emailId(patient.getEmailId()).name(patient.getName()).password(patient.getPassword())
				.phoneNumber(patient.getPhoneNumber()).updatedAt(patient.getUpdatedAt()).build();
	}

	public List<PatientDto> retreiveAllPatients() {
		return patientRepository.findAllByOrderByCreatedAtAsc().parallelStream()
				.map(patient -> PatientDto.builder().id(patient.getId()).address(patient.getAddress())
						.createdAt(patient.getCreatedAt()).emailId(patient.getEmailId()).name(patient.getName())
						.password(patient.getPassword()).phoneNumber(patient.getPhoneNumber())
						.updatedAt(patient.getUpdatedAt()).build())
				.collect(Collectors.toList());
	}

	public UUID createPatient(final PatientCreationRequest patientCreationRequest) {
		final var patient = new Patient();
		patient.setName(patientCreationRequest.getName());
		patient.setEmailId(patientCreationRequest.getEmailId());
		patient.setAddress(patientCreationRequest.getAddress());
		patient.setPhoneNumber(patientCreationRequest.getPhoneNumber());
		patient.setPassword(patientCreationRequest.getPassword());
		return patientRepository.save(patient).getId();
	}

	public PatientDto updatePatient(final PatientUpdationRequest patientUpdationRequest) {
		final var patient = patientRepository.findById(patientUpdationRequest.getPatientId())
				.orElseThrow(() -> new RuntimeException("INVALID PATIENT ID"));
		patient.setAddress(patientUpdationRequest.getAddress());
		patient.setName(patientUpdationRequest.getName());
		patient.setPhoneNumber(patientUpdationRequest.getPhoneNumber());
		patient.setPassword(patientUpdationRequest.getPassword());
		final var savedPatient = patientRepository.save(patient);
		return PatientDto.builder().id(savedPatient.getId()).address(savedPatient.getAddress())
				.createdAt(savedPatient.getCreatedAt()).emailId(savedPatient.getEmailId()).name(savedPatient.getName())
				.password(savedPatient.getPassword()).phoneNumber(savedPatient.getPhoneNumber())
				.updatedAt(savedPatient.getUpdatedAt()).build();
	}

	public void deletePatient(final UUID patientId) {
		patientRepository.deleteById(patientId);
	}

}
