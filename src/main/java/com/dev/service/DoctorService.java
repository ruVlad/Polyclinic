package com.dev.service;

import com.dev.entity.Doctor;

import java.util.List;

public interface DoctorService {
    void insert(Doctor doctor);

    void update(Doctor doctor);

    void delete(int id);

    Doctor getById(int id);

    List<Doctor> getAll();
}
