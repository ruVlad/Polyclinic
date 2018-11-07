package com.dev.service.impl;

import com.dev.dao.DiseasesDAO;
import com.dev.entity.Diseases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.service.DiseasesService;

import java.util.List;

@Service
public class DiseasesServiceImpl implements DiseasesService {

    @Autowired
    public DiseasesDAO diseasesDAO;

    @Override
    public void insert(Diseases diseases) {
        diseasesDAO.insert(diseases);
    }

    @Override
    public void update(Diseases diseases) {
        diseasesDAO.update(diseases);
    }

    @Override
    public Diseases getById(int id) {
        return diseasesDAO.getById(id);
    }

    @Override
    public void delete(int id) {
        diseasesDAO.delete(id);
    }

    @Override
    public List<Diseases> getAll() {
        return diseasesDAO.getAll();
    }
}
