
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
        <% String[] names = new String[4];
            names[0] = "Frank";
            names[1] = "Gertrude";
            names[2] = "Henry";
            names[3] = "Imogen";

            int[] id = new int[4];
            id[0] = 101;
            id[1] = 102;
            id[2] = 103;
            id[3] = 104;
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>ID</th>
                </tr>
            </thead>
            <tbody>
                <% int i = 0;
                    for (i = 0; i < 4; i++)
                    {
                %>

                <tr>
                    <td><%= names[i]%></td>
                    <td><%= id[i]%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    </body>
</html>
