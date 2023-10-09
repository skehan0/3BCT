<%-- 
    Document   : displayCustomer
    Created on : 2 Oct 2023, 17:55:28
    Author     : skeha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customers</title>
</head>
<body>
    <h1>Customers</h1>
    <table>
        <thead>
            <tr>
                <th>Customer Number</th>
                <th>Customer Name</th>
                <th>Country</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Post Code</th>
                <th>Credit Limit</th>
            </tr>
        </thead>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.customerNumber}</td>
                <td>${customer.customerName}</td>
                <td>${customer.country}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td>${customer.postCode}</td>
                <td>${customer.creditLimit}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>