<%-- 
    Document   : today.jsp
    Created on : 19 Sep 2022, 17:17:12
    Author     : O_Molloy
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Date today = new Date();%>

        <h1>Hello, today is <%=today%></h1>

        <h2>
            <%
                PrintWriter writer = new PrintWriter(out);
                writer.printf("Just another %tA in the month of %tB in the year %tY%n", today, today, today);
            %>
        </h2>

    </body>
</html>
