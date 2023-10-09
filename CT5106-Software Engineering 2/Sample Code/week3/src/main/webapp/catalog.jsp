
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
        <h1>Products</h1>
        <table>
            <thead> <td> <b> Products </b></td></thead>
            <%
                String products[] = (String[]) request.getAttribute("products");
                for (int i = 0; i < products.length; i++)
                {
            %>
        <tr> <td>
                <%-- <% out.println(products[i]); %> --%>
                <%= products[i] %>
            </td> </tr>
        <%
            }
        %>
    </table>

</body>
</html>
