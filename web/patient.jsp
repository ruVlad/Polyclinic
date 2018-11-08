<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Patient</title>
</head>
<body>
<form action="PatientController.do" method="post">
    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Patient ID</label>
            <input type="text"
                   name="id" value="<c:out value="${patient.id}" />"
                   readonly="readonly" placeholder="Patient ID"/>
        </div>
        <div>
            <%--@declare id="name"--%><label for="name">Name</label>
            <input type="text"
                   name="name" value="<c:out value="${patient.name}" />"
                   placeholder="Name"/>
        </div>
        <div>
            <%--@declare id="age"--%><label for="age">Age</label>
            <input type="text"
                   name="age" value="<c:out value="${patient.age}" />"
                   placeholder="Age"/>
        </div>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</body>
</html>