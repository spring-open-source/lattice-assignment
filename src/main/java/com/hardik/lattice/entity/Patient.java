package com.hardik.lattice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Table(name = "patients")
@Data
public class Patient implements Serializable {

	private static final long serialVersionUID = -4420522255644898499L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private UUID id;

	@Column(name = "name", nullable = false)
	@Length(min = 3, message = "NAME SHOULD BE ATLEAST 3 CHARACTERS LONG")
	private String name;

	@Column(name = "address", nullable = false)
	@Length(min = 10, message = "ADDRESS SHOULD BE ATLEAST 10 CHARACTERS LONG")
	private String address;

	@Column(name = "email_id", nullable = false, unique = true)
	@Email(message = "EMAIL ID SHOULD BE A VALID ONE")
	private String emailId;

	@Column(name = "phone_number", nullable = false, unique = true)
	@Length(min = 10, message = "PHONE NUMBER SHOULD BE ATLEAST 10 DEGITS LONG")
	private String phoneNumber;

	@Column(name = "password", nullable = false)
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{8,15}$", message = "PASSWORD SHOULD BE BETWEEN 8-15 CHARACTERS WITH COMBINATION OF DIGITS, CAPITAL AND SMALL ALPHABETICALL CHARACTERS")
	private String password;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false, updatable = true)
	private LocalDateTime updatedAt;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	private Set<Appointment> appointment;

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
