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
        <% for (int i = 1; i <= 25; i++)
            {
        %>
        <p style="font-size:<%=i%>pt"> Getting Bigger </p>
        <%
            }
        %>

    </body>
</html>
