
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
        <% String[] shapes = new String[3];
            shapes[0] = "Circle";
            shapes[1] = "Square";
            shapes[2] = "Triangle";%>

        <h2>Items</h2>
        <ul>
            <li><%= shapes[0]%></li>
            <li><%= shapes[1]%></li>
            <li><%= shapes[2]%></li>
        </ul>
    </body>
</html>
