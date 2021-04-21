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

import com.hardik.lattice.entity.Appointment;
import com.hardik.lattice.request.AppointmentCreationRequest;
import com.hardik.lattice.request.AppointmentUpdationRequest;
import com.hardik.lattice.service.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AppointmentController {

	private final AppointmentService appointmentService;

	@GetMapping("v1/appointment")
	public List<Appointment> retreiveAllAppointmentHandler() {
		return appointmentService.retreiveAllAppointments();
	}

	@GetMapping("v1/appointment/{patientId}")
	public List<Appointment> retreiveAllAppointmentHandler(
			@PathVariable(name = "patientId", required = true) final UUID patientId) {
		return appointmentService.retreiveAppointmentsForPatient(patientId);
	}

	@GetMapping("v1/appointment/{appointmentId}")
	public Appointment retreiveAppointmentHandler(
			@PathVariable(name = "appointmentId", required = true) final UUID appointmentId) {
		return appointmentService.retreiveAppointment(appointmentId);
	}

	@PostMapping("v1/appointment")
	public UUID appointmentCreationHandler(
			@RequestBody(required = true) final AppointmentCreationRequest appointmentCreationRequest) {
		return appointmentService.createAppointment(appointmentCreationRequest);
	}

	@PutMapping("v1/appointment")
	public Appointment appointmentUpdationHandler(
			@RequestBody(required = true) final AppointmentUpdationRequest appointmentUpdationRequest) {
		return appointmentService.updateAppointment(appointmentUpdationRequest);
	}

	@DeleteMapping("v1/appointment/{appointmentId}")
	public void rdeleteAppointmentHandler(
			@PathVariable(name = "appointmentId", required = true) final UUID appointmentId) {
		appointmentService.deleteAppointment(appointmentId);
	}

}
