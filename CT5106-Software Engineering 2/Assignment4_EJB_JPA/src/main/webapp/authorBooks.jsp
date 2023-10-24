<%@ include file = "/jspf/header.jspf" %>

<c:set var='view' value='/artistArtwork' scope='session' />

<h2><fmt:message key='booksby' /> ${selectedArtist.firstname} ${selectedArtist.surname} </h2>

    <c:forEach var="book" items="${artistArtwork}" varStatus="iter">
        <img src="${initParam.bookImagePath}${book.coverimage}.png"
             alt="No cover image found" width="250" height="300">
        <br><br>
        <h1><fmt:message key="${artwork.title}"/></h1>
        <h2><fmt:message key='pubyear' /> ${artwork.year}</h2>
    </c:forEach>

<%@ include file = "/jspf/footer.jspf" %>