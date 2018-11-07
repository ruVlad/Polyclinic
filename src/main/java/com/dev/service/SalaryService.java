package com.dev.service;

import com.dev.entity.Salary;

import java.util.List;

public interface SalaryService {

    void insert(Salary salary);

    void update(Salary salary);

    void delete(int id);

    Salary getById(int id);

    List<Salary> getAll();
}
