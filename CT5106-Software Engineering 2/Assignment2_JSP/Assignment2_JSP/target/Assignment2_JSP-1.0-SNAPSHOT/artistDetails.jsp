<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="javapackage.Artist" %>

<%-- 
    Document   : artistDetails
    Created on : 21 Sep 2023, 10:50:48
    Author     : skeha
--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Artist Details</title>
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>
    <h1>Artist Details</h1>
    <c:forEach var="artist" items="${sessionScope.artistList}">
        <c:if test="${param.artistId == artist.getId()}">
            
            <td>Name:</td>
            <h1>${artist.getFirstName()} ${artist.getSurname()}</h1>
            
            <td>Photo:</td>
            <img src="${artist.getPhotoURL()}">
            
            <p>Biography: ${artist.getBiography()}</p>
        </c:if>
    </c:forEach>
    <p><a href="displayArtists.jsp">Back to Artist List</a></p>
</body>
</html>
