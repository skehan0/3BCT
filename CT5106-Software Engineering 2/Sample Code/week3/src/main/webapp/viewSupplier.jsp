<a href="viewSupplier.jsp"></a>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="css/styles.css" rel="stylesheet">
        <title>Supplier Details</title>
    </head>
    <body>
        <h1>Supplier Details</h1>
        <table>
            <c:forEach var="prod" items="${catalogue}">
                <c:if test="${prod.ID == param.id}">
                    <tr>
                        <td>Name</td><td>${prod.supplier.name}</td>
                    </tr>
                    <tr>
                        <td>Address</td><td>${prod.supplier.address}</td>
                    </tr>
                    <tr>
                        <td>Telephone</td><td>${prod.supplier.telephone}</td>
                    </tr>
                    <tr>
                        <td>Email</td><td>${prod.supplier.email}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </body>
</html>