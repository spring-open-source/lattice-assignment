package com.hardik.lattice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hardik.lattice.entity.Appointment;
import com.hardik.lattice.repository.AppointmentRepository;
import com.hardik.lattice.repository.PatientRepository;
import com.hardik.lattice.request.AppointmentCreationRequest;
import com.hardik.lattice.request.AppointmentUpdationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;

	private final PatientRepository patientRepository;

	public List<Appointment> retreiveAllAppointments() {
		return appointmentRepository.findAllByOrderByTimeAsc();
	}

	public List<Appointment> retreiveAppointmentsForPatient(final UUID patientId) {
		return patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("INVALID PATIENT ID"))
				.getAppointment().parallelStream().collect(Collectors.toList());
	}

	public Appointment retreiveAppointment(final UUID appointmentId) {
		return appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new RuntimeException("INVALID APPOINTMENT ID"));
	}

	public UUID createAppointment(final AppointmentCreationRequest appointmentCreationRequest) {
		final var appointment = new Appointment();
		appointment.setCompleted(false);
		appointment.setPatientId(appointmentCreationRequest.getPatientId());
		appointment.setTime(appointmentCreationRequest.getTime());
		return appointmentRepository.save(appointment).getId();
	}

	public Appointment updateAppointment(final AppointmentUpdationRequest appointmentUpdationRequest) {
		final var appointment = appointmentRepository.findById(appointmentUpdationRequest.getAppointmentId())
				.orElseThrow(() -> new RuntimeException("INVALID APPOINTMENT ID"));
		appointment.setCompleted(appointmentUpdationRequest.getCompleted());
		appointment.setTime(appointment.getTime());
		return appointmentRepository.save(appointment);
	}

	public void deleteAppointment(final UUID appointmentId) {
		appointmentRepository.deleteById(appointmentId);
	}

}
