<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Student</title>
</head>
<body>
<form action="PolyclinicController.do" method="post">
    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Doctor ID</label>
            <input type="text"
                   name="id" value="<c:out value="${doctor.id}" />"
                   readonly="readonly" placeholder="Doctor ID"/>
        </div>
        <div>
            <%--@declare id="name"--%><label for="name">Name</label>
            <input type="text"
                   name="name" value="<c:out value="${doctor.name}" />"
                   placeholder="Name"/>
        </div>
        <div>
            <%--@declare id="age"--%><label for="age">Age</label>
            <input type="text"
                   name="age" value="<c:out value="${doctor.age}" />"
                   placeholder="Age"/>
        </div>
        <div>
            <%--@declare id="email"--%><label for="email">Email</label>
            <input type="text"
                   name="email"
                   value="<c:out value="${doctor.email}" />" placeholder="Email"/>
        </div>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</body>
</html>