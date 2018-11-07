package com.dev.service.impl;

import com.dev.dao.DoctorDAO;
import com.dev.dao.impl.DoctorDAOImpl;
import com.dev.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.service.DoctorService;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {

    public DoctorDAO doctorDAO = new DoctorDAOImpl();

    @Override
    public void insert(Doctor doctor) {
        doctorDAO.insert(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        doctorDAO.update(doctor);
    }

    @Override
    public Doctor getById(int id) {
        return doctorDAO.getById(id);
    }

    @Override
    public void delete(int id) {
        doctorDAO.delete(id);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorDAO.getAll();
    }
}
