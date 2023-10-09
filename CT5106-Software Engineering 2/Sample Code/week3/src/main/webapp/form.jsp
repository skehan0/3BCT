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
        <h1>Request Parameters</h1>
        <h2><%= request.getParameter("product")%> </h2>
        <h2><%= request.getParameter("price")%> </h2>
    </body>
</html>