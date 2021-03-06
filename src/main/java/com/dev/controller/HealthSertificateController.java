package com.dev.controller;

import com.dev.entity.HealthSertificate;
import com.dev.service.HealthSertificateService;
import com.dev.service.impl.HealthSertificateServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/HealthSertificateController")
public class HealthSertificateController extends HttpServlet {

    public static final String LIST_SERTIFICATE = "/listHealthSertificate.jsp";
    public static final String INSERT_OR_EDIT = "/healthSertificate.jsp";
    private static final long serialVersionUID = 1L;
    private HealthSertificateService healthSertificateService;

    public HealthSertificateController() {
        healthSertificateService = new HealthSertificateServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST_SERTIFICATE;
            int id = Integer.parseInt(request.getParameter("id"));
            healthSertificateService.delete(id);
            request.setAttribute("health_sertificates", healthSertificateService.getAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            HealthSertificate healthSertificate = healthSertificateService.getById(id);
            request.setAttribute("health_sertificate", healthSertificate);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_SERTIFICATE;
            request.setAttribute("health_sertificates", healthSertificateService.getAll());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HealthSertificate healthSertificate = new HealthSertificate();
        healthSertificate.setIdDiseases(Integer.parseInt(request.getParameter("id_diseases")));
        healthSertificate.setIdDoctor(Integer.parseInt(request.getParameter("id_doctor")));
        healthSertificate.setIdPatient(Integer.parseInt(request.getParameter("id_patient")));
        healthSertificate.setDateOfIssue(request.getParameter("date_of_issue"));
        healthSertificate.setExpiryDate(request.getParameter("expiry_date"));
        String id = request.getParameter("id");

        if (id == null || id.isEmpty())
            healthSertificateService.insert(healthSertificate);
        else {
            healthSertificate.setId(Integer.parseInt(id));
            healthSertificateService.update(healthSertificate);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_SERTIFICATE);
        request.setAttribute("health_sertificates", healthSertificateService.getAll());
        view.forward(request, response);
    }
}
