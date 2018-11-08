package com.dev.controller;

import com.dev.entity.Patient;
import com.dev.service.PatientService;
import com.dev.service.impl.PatientServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/PatientController")
public class PatientController extends HttpServlet {

    public static final String LIST_PATIENT = "/listPatient.jsp";
    public static final String INSERT_OR_EDIT = "/patient.jsp";
    private static final long serialVersionUID = 1L;
    private PatientService patientService;

    public PatientController() {
        patientService = new PatientServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST_PATIENT;
            int id = Integer.parseInt(request.getParameter("id"));
            patientService.delete(id);
            request.setAttribute("patients", patientService.getAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Patient patient = patientService.getById(id);
            request.setAttribute("patient", patient);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_PATIENT;
            request.setAttribute("patients", patientService.getAll());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Patient patient = new Patient();
        patient.setName(request.getParameter("name"));
        patient.setAge(Integer.parseInt(request.getParameter("age")));
        String id = request.getParameter("id");

        if (id == null || id.isEmpty())
            patientService.insert(patient);
        else {
            patient.setId(Integer.parseInt(id));
            patientService.update(patient);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PATIENT);
        request.setAttribute("patients", patientService.getAll());
        view.forward(request, response);
    }
}
