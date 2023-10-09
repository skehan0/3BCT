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
        <%! int i = 0; %>
        <h1>JSP Page Calls Itself</h1>
        <% i++; %>
        <h2> i = <%= i %></h2>
        <br>
        <h3>form without action just calls the same page it is on </h3>
        <form>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
