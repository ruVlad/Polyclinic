package com.dev.dao.impl;

import com.dev.dao.DiseasesDAO;
import com.dev.entity.Diseases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class DiseasesDAOImpl implements DiseasesDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public DiseasesDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Diseases> rowMapper = new RowMapper<Diseases>() {
        public Diseases mapRow(ResultSet rs, int rowNum) throws SQLException {
            Diseases diseases = new Diseases();
            diseases.setId(rs.getInt("id"));
            diseases.setName(rs.getString("name"));
            diseases.setComment(rs.getString("comment"));
            return diseases;
        }
    };

    public void insert(Diseases diseases) {
        String sql = "INSERT INTO diseases(name, comment) VALUES(?,?)";
        jdbcTemplate.update(sql, diseases.getName(), diseases.getComment());
    }

    public void update(Diseases diseases) {
        String sql = "UPDATE diseases SET name=?, comment=? WHERE id=?";
        jdbcTemplate.update(sql, diseases.getName(), diseases.getComment(), diseases.getId());

    }

    public void delete(Diseases diseases) {
        jdbcTemplate.update("DELETE FROM diseases WHERE id=?", diseases.getId());
    }

    public Diseases getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM diseases WHERE id=?", rowMapper, id);
    }

    public List<Diseases> getAll() {
        return jdbcTemplate.query("SELECT * FROM diseases", rowMapper);
    }
}
