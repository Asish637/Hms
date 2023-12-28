package org.jt.hmsapptests.service;

import java.util.List;

import org.jt.hmsapptests.entity.Patient;
import org.jt.hmsapptests.exception.ResourceNotFoundException;
import org.jt.hmsapptests.repository.PatientRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient create(Patient patient){
        Patient savePatient= patientRepository.save(patient);
        return savePatient;
    }

    public Patient update(String patientId, Patient patient){
        Patient patId= patientRepository.findById(patientId).orElseThrow(() ->new ResourceNotFoundException("Not Found"));
        patId.setPatientAddress(patient.getPatientAddress());
        patId.setPatientName(patient.getPatientName());
        Patient updatePatient= patientRepository.save(patId);
        return updatePatient;
    }

    public List<Patient> getAll(){
        List<Patient> getall = patientRepository.findAll();
        return getall;
    }

    public Patient getDataById(String patientId){
        Patient dataById = patientRepository.findById(patientId).orElseThrow(() ->new ResourceNotFoundException("Not Fount"));
        return dataById;
    }


    public void deleteById(String patientId){
        patientRepository.deleteById(patientId);
    }



}
