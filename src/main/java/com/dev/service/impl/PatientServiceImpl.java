package com.dev.service.impl;

import com.dev.dao.PatientDAO;
import com.dev.dao.impl.PatientDAOImpl;
import com.dev.entity.Patient;
import com.dev.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    public PatientDAO patientDAO = new PatientDAOImpl();

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
