package org.jt.hmsapptests.controller;

import java.util.List;

import org.jt.hmsapptests.entity.Patient;
import org.jt.hmsapptests.service.PatientService;
import org.jt.hmsapptests.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/save")
    public Patient create(@RequestBody Patient patient) {
        Patient createPatient = patientService.create(patient);
        return createPatient;
    }

    @PutMapping("/update/{patientId}")
    public Patient update(@PathVariable String patientId, @RequestBody Patient patient) {
        Patient updatePatient = patientService.update(patientId, patient);
        return updatePatient;
    }

    @GetMapping("/alldata")
    public List<Patient> getAll() {
        List<Patient> getall = patientService.getAll();
        return getall;
    }

    @GetMapping("/data/{patientId}")
    public Patient getById(@PathVariable String patientId) {
        Patient detaById = patientService.getDataById(patientId);
        return detaById;
    }

    public ResponseEntity<ApiResponse> delete(@PathVariable String patientId) {
        patientService.deleteById(patientId);
        return new ResponseEntity<>(new ApiResponse("Deleted Successfully"), HttpStatus.OK);

    }

}