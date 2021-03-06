package com.dev.service.impl;

import com.dev.dao.DiseasesDAO;
import com.dev.dao.impl.DiseasesDAOImpl;
import com.dev.entity.Diseases;
import com.dev.service.DiseasesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseasesServiceImpl implements DiseasesService {

    public DiseasesDAO diseasesDAO = new DiseasesDAOImpl();

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
