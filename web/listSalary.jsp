<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Salary</title>
</head>
<body>
<ul>
    <li><a href="DoctorController?action=listDoctor" class="active">Doctors</a></li>
    <li><a href="DiseasesController?action=listDiseases">Diseases</a></li>
    <li><a href="HealthSertificateController?action=listHealthSertificate">Health Sertificates</a></li>
    <li><a href="PatientController?action=listPatient">Patients</a></li>
    <li>Salaries</li>
</ul>
<table>
    <thead>
    <tr>
        <th>Salary ID</th>
        <th>Doctor ID</th>
        <th>Sum</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${salaries}" var="salary">
        <tr>
            <td><c:out value="${salary.id}" /></td>
            <td><c:out value="${salary.idDoctor}" /></td>
            <td><c:out value="${patient.sum}" /></td>
            <td><a
                    href="SalaryController.do?action=edit&id=<c:out value="${salary.id }"/>">Update</a></td>
            <td><a
                    href="SalaryController.do?action=delete&id=<c:out value="${salary.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="SalaryController.do?action=insert">Add Salary</a>
</p>
</body>
</html>