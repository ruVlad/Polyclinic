package com.dev.dao.impl;

import com.dev.dao.SalaryDAO;
import com.dev.entity.Salary;
import com.dev.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {

    private Connection conn;


    public SalaryDAOImpl() {
        conn = DBUtil.getConnection();
    }

    @Override
    public void insert(Salary salary) {
        try {
            String query = "insert into salary (id_doctor, sum) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, salary.getIdDoctor());
            preparedStatement.setInt(2, salary.getSum());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "delete from salary where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Salary salary) {
        try {
            String query = "update salary set id_doctor=?, sum=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, salary.getIdDoctor());
            preparedStatement.setInt(2, salary.getSum());
            preparedStatement.setInt(3, salary.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Salary> getAll() {
        List<Salary> salaries = new ArrayList<Salary>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from salary");
            while (resultSet.next()) {
                Salary salary = new Salary();
                salary.setId(resultSet.getInt("id"));
                salary.setIdDoctor(resultSet.getInt("id_doctor"));
                salary.setSum(resultSet.getInt("sum"));
                salaries.add(salary);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaries;
    }

    @Override
    public Salary getById(int id) {
        Salary salary = new Salary();
        try {
            String query = "select * from salary where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                salary.setId(resultSet.getInt("id"));
                salary.setIdDoctor(resultSet.getInt("id_doctor"));
                salary.setSum(resultSet.getInt("sum"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salary;
    }

}