package com.hardik.lattice.request;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class PatientUpdationRequest {

	private final UUID patientId;
	private final String phoneNumber;
	private final String name;
	private final String address;
	private final String password;

}
