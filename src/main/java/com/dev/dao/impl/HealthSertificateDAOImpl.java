package com.dev.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.DoctorDAO;
import com.dev.dao.HealthSertificateDAO;
import com.dev.entity.Doctor;
import com.dev.entity.HealthSertificate;
import com.dev.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.Doc;

public class HealthSertificateDAOImpl implements HealthSertificateDAO {

    private Connection conn;


    public HealthSertificateDAOImpl() {
        conn = DBUtil.getConnection();
    }
    @Override
    public void insert( HealthSertificate healthSertificate) {
        try {
            String query = "insert into health_sertificate (id_diseases, id_doctor, id_patient, date_of_issue, expiry_date) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt( 1, healthSertificate.getIdDiseases() );
            preparedStatement.setInt( 2, healthSertificate.getIdDoctor() );
            preparedStatement.setInt( 3, healthSertificate.getIdPatient() );
            preparedStatement.setString( 4, healthSertificate.getDateOfIssue() );
            preparedStatement.setString( 5, healthSertificate.getExpiryDate() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete( int id ) {
        try {
            String query = "delete from health_sertificate where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update( HealthSertificate healthSertificate) {
        try {
            String query = "update health_sertificate set id_diseases=?, id_doctor=?, id_patient=?, date_of_issue=?, expiry_date=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt( 1, healthSertificate.getIdDiseases() );
            preparedStatement.setInt( 2, healthSertificate.getIdDoctor() );
            preparedStatement.setInt( 3, healthSertificate.getIdPatient() );
            preparedStatement.setString( 4, healthSertificate.getDateOfIssue() );
            preparedStatement.setString( 5, healthSertificate.getExpiryDate() );
            preparedStatement.setInt(6, healthSertificate.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<HealthSertificate> getAll() {
        List<HealthSertificate> healthSertificates = new ArrayList<HealthSertificate>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from health_sertificate" );
            while( resultSet.next() ) {
                HealthSertificate healthSertificate= new HealthSertificate();
                healthSertificate.setId( resultSet.getInt( "id" ) );
                healthSertificate.setIdDiseases( resultSet.getInt( "id_diseases" ) );
                healthSertificate.setIdDoctor( resultSet.getInt( "id_doctor" ) );
                healthSertificate.setIdPatient( resultSet.getInt( "id_patient" ) );
                healthSertificate.setDateOfIssue( resultSet.getString( "date_of_issue" ) );
                healthSertificate.setExpiryDate( resultSet.getString( "expiry_date" ) );
                healthSertificates.add(healthSertificate);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return healthSertificates;
    }
    @Override
    public HealthSertificate getById(int id) {
        HealthSertificate healthSertificate= new HealthSertificate();
        try {
            String query = "select * from health_sertificate where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                healthSertificate.setId( resultSet.getInt( "id" ) );
                healthSertificate.setIdDiseases( resultSet.getInt( "id_diseases" ) );
                healthSertificate.setIdDoctor( resultSet.getInt( "id_doctor" ) );
                healthSertificate.setIdPatient( resultSet.getInt( "id_patient" ) );
                healthSertificate.setDateOfIssue( resultSet.getString( "date_of_issue" ) );
                healthSertificate.setExpiryDate( resultSet.getString( "expiry_date" ) );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return healthSertificate;
    }

}