<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Add New Disease</title>
</head>
<body>
<form action="DiseasesController.do" method="post">
    <fieldset>
        <div>
            <%--@declare id="id"--%><label for="id">Disease ID</label>
            <input type="text"
                   name="id" value="<c:out value="${disease.id}" />"
                   readonly="readonly" placeholder="Disease ID"/>
        </div>
        <div>
            <%--@declare id="name"--%><label for="name">Name</label>
            <input type="text"
                   name="name" value="<c:out value="${disease.name}" />"
                   placeholder="Name"/>
        </div>
        <div>
            <%--@declare id="comment"--%><label for="comment">Comment</label>
            <input type="text"
                   name="comment" value="<c:out value="${disease.comment}" />"
                   placeholder="Comment"/>
        </div>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</body>
</html>