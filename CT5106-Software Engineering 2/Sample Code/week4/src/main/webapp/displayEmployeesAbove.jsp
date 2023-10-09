<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <title>Employees Above</title>
    </head>
    <body>
        <h1>List of Employees Above Threshold</h1>
        <table>
            <thead>
                <tr>
            <b>
                <td>ID</td><td>Name</td><td>Salary</td>
            </b>
        </tr>
    </thead>
    <c:forEach var="emp" items="${employeesAbove}">
        <tr>
            <td>${emp.empid}</td><td>${emp.name}</td><td>${emp.salary}</td>
        </tr>
    </c:forEach>
</table>
<br><br><br>

<form action="SalariesAbove" method="POST">
    Threshold: <input type="text" name="threshold" value="0"><br>
    <input type="submit" value="Show" />

</form>

<br><br>

<h2><a href="index.html">Home</a></h2>

</body>
</html>
