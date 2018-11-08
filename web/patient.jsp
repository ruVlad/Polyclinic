<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
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
            background-color: #4CAF50;
        }

        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: #111;
            color: white;
            text-align: center;
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
            background-color: #4CAF50;
            color: white;
        }

        fieldset {
            color: white;
            background-color: #333;
        }
    </style>
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