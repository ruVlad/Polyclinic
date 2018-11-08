package com.dev.controller;

import com.dev.dao.DoctorDAO;
import com.dev.dao.impl.DoctorDAOImpl;
import com.dev.entity.Doctor;
import com.dev.entity.Patient;
import com.dev.entity.Salary;
import com.dev.service.DoctorService;
import com.dev.service.PatientService;
import com.dev.service.SalaryService;
import com.dev.service.impl.DoctorServiceImpl;
import com.dev.service.impl.PatientServiceImpl;
import com.dev.service.impl.SalaryServiceImpl;
import com.dev.util.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/SalaryController")
public class SalaryController extends HttpServlet {

    private SalaryService salaryService;
    private static final long serialVersionUID = 1L;
    public static final String LIST_DOCTOR = "/listSalary.jsp";
    public static final String INSERT_OR_EDIT = "/salary.jsp";

    public SalaryController() {
        salaryService = new SalaryServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );

        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LIST_DOCTOR;
            int id = Integer.parseInt( request.getParameter("id") );
            salaryService.delete(id);
            request.setAttribute("salaries", salaryService.getAll());
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt( request.getParameter("id") );
            Salary salary = salaryService.getById(id);
            request.setAttribute("salary", salary);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = LIST_DOCTOR;
            request.setAttribute("salaries", salaryService.getAll() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Salary salary = new Salary();
        salary.setIdDoctor(Integer.parseInt( request.getParameter( "id_doctor" )) );
        salary.setSum( Integer.parseInt(request.getParameter( "sum" )) );
        String id = request.getParameter("id");

        if( id == null || id.isEmpty() )
            salaryService.insert(salary);
        else {
            salary.setId( Integer.parseInt(id) );
            salaryService.update(salary);
        }
        RequestDispatcher view = request.getRequestDispatcher( LIST_DOCTOR );
        request.setAttribute("salaries", salaryService.getAll());
        view.forward(request, response);
    }
}
