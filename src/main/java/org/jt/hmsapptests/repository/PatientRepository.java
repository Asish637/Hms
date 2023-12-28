package org.jt.hmsapptests.repository;

import org.jt.hmsapptests.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String>{
    
}
