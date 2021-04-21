package com.hardik.lattice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Table(name = "appointments")
@Data
public class Appointment implements Serializable {

	private static final long serialVersionUID = 797469021418175890L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private UUID id;

	@Column(name = "patient_id", nullable = false)
	private UUID patientId;

	@Hidden
	@Exclude
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false, insertable = false, updatable = false)
	private Patient patient;

	@Column(name = "time", nullable = false, updatable = false)
	private LocalDateTime time;

	@Column(name = "completed", nullable = false)
	private Boolean completed;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false, updatable = true)
	private LocalDateTime updatedAt;

	@PrePersist
	public void onCreate() {
		this.id = UUID.randomUUID();
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
