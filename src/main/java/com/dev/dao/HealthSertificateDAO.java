package com.dev.dao;

import com.dev.entity.HealthSertificate;

import java.util.List;

public interface HealthSertificateDAO {
    void insert(HealthSertificate healthSertificate);

    void update(HealthSertificate healthSertificate);

    void delete(int id);

    HealthSertificate getById(int id);

    List<HealthSertificate> getAll();
}
