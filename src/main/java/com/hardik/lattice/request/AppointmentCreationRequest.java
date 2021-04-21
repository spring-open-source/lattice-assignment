package com.hardik.lattice.request;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class AppointmentCreationRequest {

	private final UUID patientId;
	private final LocalDateTime time;

}
