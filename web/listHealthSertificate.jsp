<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
            display: block;
            color: white;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a {
            display: block;
            color: white;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: darkred;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:hover {
            background-color: #f2f2f2
        }

        th {
            background-color: darkred;
            color: white;
        }

        a {
            display: block;
            color: black;
            text-decoration: none;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Health Sertificates</title>
</head>
<body>
<ul>
    <li><a href="DoctorController?action=listDoctor">Doctors</a></li>
    <li><a href="DiseasesController?action=listDiseases">Diseases</a></li>
    <li><a page="HealthSertificateController?action=listHealthSertificate" class="active">Health Sertificates</a></li>
    <li><a href="PatientController?action=listPatient">Patients</a></li>
    <li><a href="SalaryController?action=listSalary">Salaries</a></li>
</ul>
<table>
    <thead>
    <tr>
        <th>Health Sertificate ID</th>
        <th>Disease ID</th>
        <th>Doctor ID</th>
        <th>Patient ID</th>
        <th>Date of issue</th>
        <th>Expiry Date</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${health_sertificates}" var="health_sertificate">
        <tr>
            <td><c:out value="${health_sertificate.id}"/></td>
            <td><c:out value="${health_sertificate.idDiseases}"/></td>
            <td><c:out value="${health_sertificate.idDoctor}"/></td>
            <td><c:out value="${health_sertificate.idPatient}"/></td>
            <td><c:out value="${health_sertificate.dateOfIssue}"/></td>
            <td><c:out value="${health_sertificate.expiryDate}"/></td>
            <td><a
                    href="HealthSertificateController.do?action=edit&id=<c:out value="${health_sertificate.id }"/>">Update</a>
            </td>
            <td><a
                    href="HealthSertificateController.do?action=delete&id=<c:out value="${health_sertificate.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="HealthSertificateController.do?action=insert">Add Health Sertificate</a>
</p>
</body>
</html>