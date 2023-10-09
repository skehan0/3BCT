<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-size: 40px;
            }
        </style>
    </head>
    <body>
        <h1>Pre-Defined Variables</h1>
        <h2> Application Context Path = <%= application.getContextPath()%></h2>
        <h2> Session ID = <%= session.getId()%> </h2>
        <h2> Request Remote Address = <%= request.getRemoteAddr() %> </h2>
    </body>
</html>
