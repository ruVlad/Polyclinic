package com.dev.dao.impl;

import com.dev.dao.DoctorDAO;
import com.dev.entity.Doctor;
import com.dev.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    private Connection conn;


    public DoctorDAOImpl() {
        conn = DBUtil.getConnection();
    }

    @Override
    public void insert(Doctor doctor) {
        try {
            String query = "insert into doctor (name, age, email) values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setInt(2, doctor.getAge());
            preparedStatement.setString(3, doctor.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "delete from doctor where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Doctor doctor) {
        try {
            String query = "update doctor set name=?, age=?, email=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setInt(2, doctor.getAge());
            preparedStatement.setString(3, doctor.getEmail());
            preparedStatement.setInt(4, doctor.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> students = new ArrayList<Doctor>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from doctor");
            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setAge(resultSet.getInt("age"));
                doctor.setEmail(resultSet.getString("email"));
                students.add(doctor);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Doctor getById(int id) {
        Doctor doctor = new Doctor();
        try {
            String query = "select * from doctor where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctor.setId(resultSet.getInt("id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setAge(resultSet.getInt("age"));
                doctor.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

}