package com.dev.dao.impl;

import com.dev.dao.HealthSertificateDAO;
import com.dev.entity.HealthSertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HealthSertificateDAOImpl implements HealthSertificateDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public HealthSertificateDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }



    private RowMapper<HealthSertificate> rowMapper = new RowMapper<HealthSertificate>() {
        public HealthSertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
            HealthSertificate healthSertificate = new HealthSertificate();
            healthSertificate.setId(rs.getInt("id"));
            healthSertificate.setIdDiseases(rs.getInt("id_diseases"));
            healthSertificate.setIdDoctor(rs.getInt("id_doctor"));
            healthSertificate.setIdPatient(rs.getInt("id_patient"));
            healthSertificate.setDateOfIssue(rs.getString("date_of_issue"));
            healthSertificate.setExpiryDate(rs.getString("expiry_date"));
            return healthSertificate;
        }
    };

    public void insert(HealthSertificate healthSertificate) {
        String sql = "INSERT INTO health_sertificate(id_diseases, id_doctor, id_patient, date_of_issue, expiry_date) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, healthSertificate.getIdDiseases(), healthSertificate.getIdDoctor(), healthSertificate.getIdPatient(),
                healthSertificate.getDateOfIssue(), healthSertificate.getExpiryDate());
    }

    public void update(HealthSertificate healthSertificate) {
        String sql = "UPDATE health_sertificate SET id_diseases=?, id_doctor=?, id_patient=?, date_of_issue=?, expiry_date=? WHERE id=?";
        jdbcTemplate.update(sql, healthSertificate.getIdDiseases(), healthSertificate.getIdDoctor(), healthSertificate.getIdPatient(),
                healthSertificate.getDateOfIssue(), healthSertificate.getExpiryDate(), healthSertificate.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM health_sertificate WHERE id=?", id);
    }

    public HealthSertificate getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM health_sertificate WHERE id=?", rowMapper, id);
    }

    public List<HealthSertificate> getAll() {
        return jdbcTemplate.query("SELECT * FROM health_sertificate", rowMapper);
    }
}
