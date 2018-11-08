package com.dev.controller;

import com.dev.dao.DoctorDAO;
import com.dev.dao.impl.DoctorDAOImpl;
import com.dev.entity.Diseases;
import com.dev.entity.Doctor;
import com.dev.service.DiseasesService;
import com.dev.service.DoctorService;
import com.dev.service.impl.DiseasesServiceImpl;
import com.dev.service.impl.DoctorServiceImpl;
import com.dev.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DiseasesController")
public class DiseasesController extends HttpServlet {

    private DiseasesService diseasesService;
    private static final long serialVersionUID = 1L;
    public static final String LIST_DOCTOR = "/listDiseases.jsp";
    public static final String INSERT_OR_EDIT = "/diseases.jsp";

    public DiseasesController() {
        diseasesService = new DiseasesServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );

        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LIST_DOCTOR;
            int id = Integer.parseInt( request.getParameter("id") );
            diseasesService.delete(id);
            request.setAttribute("diseasess", diseasesService.getAll());
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt( request.getParameter("id") );
            Diseases diseases = diseasesService.getById(id);
            request.setAttribute("diseases", diseases);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = LIST_DOCTOR;
            request.setAttribute("diseases", diseasesService.getAll() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Diseases diseases = new Diseases();
        diseases.setName( request.getParameter( "name" ) );
        diseases.setComment(request.getParameter( "comment" ));
        String id = request.getParameter("id");

        if( id == null || id.isEmpty() )
            diseasesService.insert(diseases);
        else {
            diseases.setId( Integer.parseInt(id) );
            diseasesService.update(diseases);
        }
        RequestDispatcher view = request.getRequestDispatcher( LIST_DOCTOR );
        request.setAttribute("diseases", diseasesService.getAll());
        view.forward(request, response);
    }
}
