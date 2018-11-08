package com.dev.controller;

import com.dev.dao.DoctorDAO;
import com.dev.dao.impl.DoctorDAOImpl;
import com.dev.entity.Doctor;
import com.dev.service.DoctorService;
import com.dev.service.impl.DoctorServiceImpl;
import com.dev.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {

    private DoctorService doctorService;
    private static final long serialVersionUID = 1L;
    public static final String LIST_DOCTOR = "/listDoctor.jsp";
    public static final String INSERT_OR_EDIT = "/doctor.jsp";

    public DoctorController() {
        doctorService = new DoctorServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );

        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LIST_DOCTOR;
            int id = Integer.parseInt( request.getParameter("id") );
            doctorService.delete(id);
            request.setAttribute("doctors", doctorService.getAll());
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt( request.getParameter("id") );
            Doctor doctor = doctorService.getById(id);
            request.setAttribute("doctor", doctor);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = LIST_DOCTOR;
            request.setAttribute("doctors", doctorService.getAll() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Doctor doctor= new Doctor();
        doctor.setName( request.getParameter( "name" ) );
        doctor.setAge( Integer.parseInt(request.getParameter( "age" )) );
        doctor.setEmail( request.getParameter( "email" ) );
        String id = request.getParameter("id");

        if( id == null || id.isEmpty() )
            doctorService.insert(doctor);
        else {
            doctor.setId( Integer.parseInt(id) );
            doctorService.update(doctor);
        }
        RequestDispatcher view = request.getRequestDispatcher( LIST_DOCTOR );
        request.setAttribute("doctors", doctorService.getAll());
        view.forward(request, response);
    }
}
