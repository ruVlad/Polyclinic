<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Salary</title>
</head>
<body>
<form action="SalaryController.do" method="post">
    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Salary ID</label>
            <input type="text"
                   name="id" value="<c:out value="${salary.id}" />"
                   readonly="readonly" placeholder="Salary ID"/>
        </div>
        <div>
            <%--@declare id="name"--%><label for="name">Doctor ID</label>
            <input type="text"
                   name="id_doctor" value="<c:out value="${salary.idDoctor}" />"
                   placeholder="Doctor ID"/>
        </div>
        <div>
            <%--@declare id="age"--%><label for="age">Sum</label>
            <input type="text"
                   name="sum" value="<c:out value="${salary.sum}" />"
                   placeholder="Saum"/>
        </div>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</body>
</html>