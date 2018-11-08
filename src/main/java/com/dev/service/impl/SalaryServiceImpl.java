package com.dev.service.impl;

import com.dev.dao.SalaryDAO;
import com.dev.dao.impl.SalaryDAOImpl;
import com.dev.entity.Salary;
import com.dev.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    public SalaryDAO salaryDAO = new SalaryDAOImpl();

    @Override
    public void insert(Salary salary) {
        salaryDAO.insert(salary);
    }

    @Override
    public void update(Salary salary) {
        salaryDAO.update(salary);
    }

    @Override
    public Salary getById(int id) {
        return salaryDAO.getById(id);
    }

    @Override
    public void delete(int id) {
        salaryDAO.delete(id);
    }

    @Override
    public List<Salary> getAll() {
        return salaryDAO.getAll();
    }
}
