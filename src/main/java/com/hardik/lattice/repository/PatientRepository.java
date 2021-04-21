package com.hardik.lattice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.lattice.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

	List<Patient> findAllByOrderByCreatedAtAsc();

}
