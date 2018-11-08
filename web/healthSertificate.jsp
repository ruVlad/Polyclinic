<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Health Sertificate</title>
</head>
<body>
<form action="HealthSertificateController.do" method="post">
    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Health Sertificate ID</label>
            <input type="text"
                   name="id" value="<c:out value="${health_sertificate.id}" />"
                   readonly="readonly" placeholder="Health Sertificate ID"/>
        </div>
        <div>
            <%--@declare id="id_diseases"--%><label for="id_diseases">ID Disease</label>
            <input type="text"
                   name="id_diseases" value="<c:out value="${health_sertificate.idDiseases}" />"
                   placeholder="ID Diseases"/>
        </div>
        <div>
            <%--@declare id="id_doctor"--%><label for="id_doctor">ID Doctor</label>
            <input type="text"
                   name="id_doctor" value="<c:out value="${health_sertificate.idDoctor}" />"
                   placeholder="ID Doctor"/>
        </div>
        <div>
            <%--@declare id="id_patient"--%><label for="id_patient">ID Patient</label>
            <input type="text"
                   name="id_patient"
                   value="<c:out value="${health_sertificate.idPatient}" />"
                   placeholder="ID Patient"/>
        </div>
        <div>
        <%--@declare id="date_of_issue"--%><label for="date_of_issue">Date of Issue</label>
        <input type="text"
               name="date_of_issue"
               value="<c:out value="${health_sertificate.dateOfIssue}" />"
               placeholder="Date Of Issue"/>
        </div>
        <div>
            <%--@declare id="expiry_date"--%><label for="expiry_date">Expiry Date</label>
            <input type="text"
                   name="expiry_date"
                   value="<c:out value="${health_sertificate.expiryDate}" />"
                   placeholder="Expiry Date"/>
        </div>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</body>
</html>