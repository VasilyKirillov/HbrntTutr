<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="address" value="${contact.address}"/>
<html>
    <head>
        <title>${contact.name}</title>
    </head>
    <body>
        <h1>${contact.name}</h1>
            <ul>
                <li>street: ${address.street}</li>
                <li>city: ${address.city}</li>
                <li>state: ${address.state}</li>
                <li>zip: ${address.zip}</li>
            </ul>
        <a href="contacts">back to contact list</a> | 
        <a href="contact?edit&id=${contact.id}">edit contact</a>
    </body>
</html>