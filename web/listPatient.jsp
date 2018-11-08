<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Patients</title>
</head>
<body>
<ul>
    <li><a href="DoctorController?action=listDoctor" class="active">Doctors</a></li>
    <li><a href="DiseasesController?action=listDiseases">Diseases</a></li>
    <li><a href="HealthSertificateController?action=listHealthSertificate">Health Sertificates</a></li>
    <li>Patients</li>
    <li><a href="SalaryController?action=listSalary">Salaries</a></li>
</ul>
<table>
    <thead>
    <tr>
        <th>Patient ID</th>
        <th>Name</th>
        <th>Age</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${patients}" var="patient">
        <tr>
            <td><c:out value="${patient.id}" /></td>
            <td><c:out value="${patient.name}" /></td>
            <td><c:out value="${patient.age}" /></td>
            <td><a
                    href="PatientController.do?action=edit&id=<c:out value="${patient.id }"/>">Update</a></td>
            <td><a
                    href="PatientController.do?action=delete&id=<c:out value="${patient.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="PatientController.do?action=insert">Add Patient</a>
</p>
</body>
</html>