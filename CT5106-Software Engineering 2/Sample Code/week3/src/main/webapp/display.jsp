<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Display Page</title>
    </head>
    <body>
        Student name is ${ param.stuname } <br>
        Student Roll No is ${param.rollno }
        
        <c:set var="num" scope="page" value="${125*3.2}"/>
        <p> ${num} </p>
        <c:if test="${num < 500}">
            <p> smaller than 500! </p>
        </c:if>
    </body>
</html>