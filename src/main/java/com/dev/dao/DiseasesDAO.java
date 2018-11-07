package com.dev.dao;

import com.dev.entity.Diseases;

import java.util.List;

public interface DiseasesDAO {
    void insert(Diseases diseases);

    void update(Diseases diseases);

    void delete(Diseases diseases);

    Diseases getById(int id);

    List<Diseases> getAll();
}
