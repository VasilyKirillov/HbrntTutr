<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <a href="contacts">back to contact list</a>
    </body>
</html>