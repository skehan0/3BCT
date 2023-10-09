
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
                <tr>
                    <td><%= names[0]%></td>
                    <td><%= id[0]%></td>
                </tr>
                <tr>
                    <td><%= names[1]%></td>
                    <td><%= id[1]%></td>
                </tr>
                <tr>
                    <td><%= names[2]%></td>
                    <td><%= id[2]%></td>
                </tr>
                <tr>
                    <td><%= names[3]%></td>
                    <td><%= id[3]%></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>