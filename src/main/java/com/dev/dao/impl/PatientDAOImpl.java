package com.dev.dao.impl;

import com.dev.dao.PatientDAO;
import com.dev.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Patient> rowMapper = new RowMapper<Patient>() {
        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Patient patient = new Patient();
            patient.setId(rs.getInt("id"));
            patient.setName(rs.getString("name"));
            patient.setAge(rs.getInt("age"));
            return patient;
        }
    };

    public void insert(Patient patient) {
        String sql = "INSERT INTO patient(name, age) VALUES(?,?)";
        jdbcTemplate.update(sql, patient.getName(), patient.getAge());
    }

    public void update(Patient patient) {
        String sql = "UPDATE patient SET name=?, ahe=? WHERE id=?";
        jdbcTemplate.update(sql, patient.getName(), patient.getAge(), patient.getId());
    }

    public void delete(Patient patient) {
        jdbcTemplate.update("DELETE FROM patient WHERE id=?", patient.getId());
    }

    public Patient getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM patient WHERE id=?", rowMapper, id);
    }

    public List<Patient> getAll() {
        return jdbcTemplate.query("SELECT * FROM patient", rowMapper);
    }
}
