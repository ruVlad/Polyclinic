package com.dev.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.DiseasesDAO;
import com.dev.dao.DoctorDAO;
import com.dev.entity.Diseases;
import com.dev.entity.Doctor;
import com.dev.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.Doc;

public class DiseasesDAOImpl implements DiseasesDAO {

    private Connection conn;


    public DiseasesDAOImpl() {
        conn = DBUtil.getConnection();
    }
    @Override
    public void insert( Diseases diseases) {
        try {
            String query = "insert into diseases (name, comment) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, diseases.getName() );
            preparedStatement.setString( 2, diseases.getComment() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete( int id ) {
        try {
            String query = "delete from diseases where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update( Diseases diseases) {
        try {
            String query = "update diseases set name=?, comment=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, diseases.getName() );
            preparedStatement.setString( 2, diseases.getComment() );
            preparedStatement.setInt( 3, diseases.getId() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Diseases> getAll() {
        List<Diseases> diseases= new ArrayList<Diseases>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from diseases" );
            while( resultSet.next() ) {
                Diseases disease= new Diseases();
                disease.setId( resultSet.getInt( "id" ) );
                disease.setName( resultSet.getString( "name" ) );
                disease.setComment( resultSet.getString( "comment" ) );
                diseases.add(disease);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diseases;
    }
    @Override
    public Diseases getById(int id) {
        Diseases diseases = new Diseases();
        try {
            String query = "select * from diseases where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                diseases.setId( resultSet.getInt( "id" ) );
                diseases.setName( resultSet.getString( "name" ) );
                diseases.setComment( resultSet.getString( "comment" ) );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diseases;
    }

}