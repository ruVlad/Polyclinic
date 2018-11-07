package com.dev.service.impl;

import com.dev.dao.PatientDAO;
import com.dev.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    public PatientDAO patientDAO;

    @Override
    public void insert(Patient patient) {
        patientDAO.insert(patient);
    }

    @Override
    public void update(Patient patient) {
        patientDAO.update(patient);
    }

    @Override
    public Patient getById(int id) {
        return patientDAO.getById(id);
    }

    @Override
    public void delete(int id) {
        patientDAO.delete(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }
}
