package com.dev.service.impl;

import com.dev.dao.HealthSertificateDAO;
import com.dev.dao.impl.HealthSertificateDAOImpl;
import com.dev.entity.HealthSertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.service.HealthSertificateService;

import java.util.List;

@Service
public class HealthSertificateServiceImpl implements HealthSertificateService {
    @Autowired
    public HealthSertificateDAO healthSertificateDAO = new HealthSertificateDAOImpl();

    @Override
    public void insert(HealthSertificate healthSertificate) {
        healthSertificateDAO.insert(healthSertificate);
    }

    @Override
    public void update(HealthSertificate healthSertificate) {
        healthSertificateDAO.update(healthSertificate);
    }

    @Override
    public HealthSertificate getById(int id) {
        return healthSertificateDAO.getById(id);
    }

    @Override
    public void delete(int id) {
        healthSertificateDAO.delete(id);
    }

    @Override
    public List<HealthSertificate> getAll() {
        return healthSertificateDAO.getAll();
    }
}
