<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Created</h1>
 
        <h3>${user.userName}</h3>
        
        <h3><c:out value="${user.userName}" /></h3>
        
        <h3>${requestScope.user.userName}</h3>
        
        <h3><c:out value="${requestScope.user.userName}" /></h3>

        <p>${appName}</p>
        <p>${sessionName}</p>
    </body>
</html>