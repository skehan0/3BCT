
<%@page import="com.mycompany.week3.Cast"%>


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
        <%
            Cast[] cast = new Cast[3];
            Cast c1 = new Cast();
            c1.setFirstName("Gussie");
            c1.setSurname("Fink-Nottle");
            c1.setDescription("Newt Fancier");
            cast[0] = c1;

            Cast c2 = new Cast();
            c2.setFirstName("Roderick");
            c2.setSurname("Spode");
            c2.setDescription("7th Earl of Sidcup");
            cast[1] = c2;

            Cast c3 = new Cast();
            c3.setFirstName("Bingo");
            c3.setSurname("Little");
            c3.setDescription("Lord of Bittlesham");
            cast[2] = c3;
        %>
        <h1>Characters</h1>

        <dl>
            <% int i = 0;
                for (i = 0; i < 3; i++)
                {
            %>
            <dt> <%= cast[i].getFirstName() + " " + c1.getSurname()%> <dt>
            <dd> <%= cast[i].getDescription()%> </dd>
            <%
                }
            %>
        </dl>
    </body>
</html>
