<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Students</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Student ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Course</th>
        <th>Year</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${doctors}" var="doctor">
        <tr>
            <td><c:out value="${doctor.id}" /></td>
            <td><c:out value="${doctor.name}" /></td>
            <td><c:out value="${doctor.age}" /></td>
            <td><c:out value="${doctor.email}" /></td>
            <td><a
                    href="PolyclinicController.do?action=edit&id=<c:out value="${doctor.id }"/>">Update</a></td>
            <td><a
                    href="PolyclinicController.do?action=delete&id=<c:out value="${doctor.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="PolyclinicController.do?action=insert">Add Student</a>
</p>
</body>
</html>