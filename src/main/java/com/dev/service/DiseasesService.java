package com.dev.service;

import com.dev.entity.Diseases;

import java.util.List;

public interface DiseasesService {
    void insert(Diseases diseases);

    void update(Diseases diseases);

    void delete(int id);

    Diseases getById(int id);

    List<Diseases> getAll();
}
