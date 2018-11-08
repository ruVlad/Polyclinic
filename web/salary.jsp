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