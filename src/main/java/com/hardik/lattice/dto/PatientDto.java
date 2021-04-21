package com.hardik.lattice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class PatientDto {

	private final UUID id;
	private final String name;
	private final String emailId;
	private final String phoneNumber;
	private final String address;
	private final String password;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
