package com.dev.dao.impl;

import com.dev.dao.SalaryDAO;
import com.dev.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalaryDAOImpl implements SalaryDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalaryDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Salary> rowMapper = new RowMapper<Salary>() {
        public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
            Salary salary = new Salary();
            salary.setId(rs.getInt("id"));
            salary.setIdDoctor(rs.getInt("id_doctor"));
            salary.setSum(rs.getInt("sum"));
            return salary;
        }
    };

    public void insert(Salary salary) {
        String sql = "INSERT INTO salary(id_doctor, sum) VALUES(?,?)";
        jdbcTemplate.update(sql, salary.getIdDoctor(), salary.getSum());
    }

    public void update(Salary salary) {
        String sql = "UPDATE salary SET id_doctor=?, sum=? WHERE id=?";
        jdbcTemplate.update(sql, salary.getIdDoctor(), salary.getSum(), salary.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM salary WHERE id=?", id);
    }

    public Salary getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM salary WHERE id=?", rowMapper, id);
    }

    public List<Salary> getAll() {
        return jdbcTemplate.query("SELECT * FROM salary", rowMapper);
    }
}
