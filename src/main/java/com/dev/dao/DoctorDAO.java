package com.dev.dao;

import com.dev.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    void insert(Doctor doctor);

    void update(Doctor doctor);

    void delete(Doctor doctor);

    Doctor getById(int id);

    List<Doctor> getAll();
}
