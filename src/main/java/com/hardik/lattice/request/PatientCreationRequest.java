package com.hardik.lattice.request;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class PatientCreationRequest {

	private final String name;
	private final String address;
	private final String emailId;
	private final String password;
	private final String phoneNumber;

}
