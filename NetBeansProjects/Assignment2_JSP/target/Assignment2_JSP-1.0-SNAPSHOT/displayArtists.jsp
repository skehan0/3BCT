<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="javapackage.Artist" %>


<%-- 
    Document   : displayArtists
    Created on : 21 Sep 2023, 10:50:48
    Author     : skeha
--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Display Artists</title>
</head>
<body>
    <h1>Summary of Artists Information</h1>
    <table style="background-color: #00ccff; color: white; border-spacing: 20px; width: 600px;">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Surname</th>
                <th>Nationality</th>
                <th>Birth Year</th>
                <th>Death Year</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="artist" items="${sessionScope.artistList}">
                <tr>
                    <td>${newArtist.getFirstName()}</td>
                    <td>${newArtist.getSurname()}</td>
                    <td>${newArtist.getNationality()}</td>
                    <td>${newArtist.getYearOfBirth()}</td>
                    <td>${newArtist.getYearOfDeath()}</td>
                    <td>
                        <form action="artistDetails.jsp" method="post">
                            <input type="hidden" name="artistId" value="${artist.getId()}">
                            <input type="submit" value="Details">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%-- Debugging output to check the artistList 
    <c:out value="${artistList}" />--%>
    <p><a href="addArtists.html">Add Artist</a></p>
</body>
</html>
