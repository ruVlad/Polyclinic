package com.dev.dao;

import com.dev.entity.Salary;

import java.util.List;

public interface SalaryDAO {

    void insert(Salary salary);

    void update(Salary salary);

    void delete(int id);

    Salary getById(int id);

    List<Salary> getAll();
}
