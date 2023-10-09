<%-- 
    Document   : visit.jsp
    Created on : 19 Sep 2022, 17:51:40
    Author     : O_Molloy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%! int numVisits1 = 0; %>
        <% int numVisits2 = 0; %>
        
        <p>numVisits1 = <%=numVisits1++%></p>
        <p>numVisits2 = <%=numVisits2++%></p>
    </body>
</html>
