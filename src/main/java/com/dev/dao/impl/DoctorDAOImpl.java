package com.dev.dao.impl;

import com.dev.dao.DoctorDAO;
import com.dev.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public DoctorDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Doctor> rowMapper = new RowMapper<Doctor>() {
        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doctor doctor = new Doctor();
            doctor.setId(rs.getInt("id"));
            doctor.setName(rs.getString("name"));
            doctor.setAge(rs.getInt("age"));
            doctor.setEmail(rs.getString("email"));
            return doctor;
        }
    };

    public void insert(Doctor doctor) {
        String sql = "INSERT INTO doctor(name, age, email) VALUES(?,?,?)";
        jdbcTemplate.update(sql, doctor.getName(), doctor.getAge(), doctor.getEmail());
    }

    public void update(Doctor doctor) {
        String sql = "UPDATE doctor SET name=?, age=?, email=? WHERE id=?";
        jdbcTemplate.update(sql, doctor.getName(), doctor.getAge(), doctor.getEmail(), doctor.getId());
    }

    public void delete(Doctor doctor) {
        jdbcTemplate.update("DELETE FROM doctor WHERE id=?", doctor.getId());
    }

    public Doctor getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM doctor WHERE id=?", rowMapper, id);
    }

    public List<Doctor> getAll() {
        return jdbcTemplate.query("SELECT * FROM doctor", rowMapper);
    }
}
