package com.hardik.lattice.request;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class AppointmentUpdationRequest {

	private final UUID appointmentId;
	private final LocalDateTime time;
	private final Boolean completed;

}
