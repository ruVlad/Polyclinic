package com.dev.dao;

import com.dev.entity.Patient;

import java.util.List;

public interface PatientDAO {
    void insert(Patient patient);

    void update(Patient patient);

    void delete(int id);

    Patient getById(int id);

    List<Patient> getAll();
}
