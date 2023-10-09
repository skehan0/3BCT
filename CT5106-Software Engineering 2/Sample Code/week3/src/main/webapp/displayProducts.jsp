<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <h1>Product Catalogue</h1>
        <table>
            <thead>
                <tr>
            <b>
                <td>Code</td><td>Name</td><td>Description</td><td>Price</td><td>Supplier</td>
            </b>
        </tr>
    </thead>
    <c:forEach var="prod" items="${catalogue}">
        <tr>
            <td>${prod.ID}</td><td>${prod.name}</td><td>${prod.description}</td><td>${prod.price}</td>
            <td>
                <form action="viewSupplier.jsp" method="post"> 
              <input type="hidden" name="id" value="${prod.ID}"> 
                    <input type="submit" value="View">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
