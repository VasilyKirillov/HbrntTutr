
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contacts List</title>
    </head>
    <body>
        <h1>Contacts</h1>
        <ul>
            <c:forEach var="contact" items="${contacts}">
                <li><a href="#">${contact.name}</a></li>
            </c:forEach>
        </ul>
        <a href="contact?add">add a new contact</a>

    </body>
</html>
