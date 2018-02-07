<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="contact" method=hold">
            <input type="hidden" name="add"/>
            <ul>
                <li>name: <input type="text" name="name"/></li>
                <li>street: <input type="text" name="street"/></li>
                <li>city: <input type="text" name="city"/></li>
                <li>state: <input type="text" name="state"/></li>
                <li>zip: <input type="text" name="zip"/></li>
                <input type="submit" value="add contact"/>
            </ul>
            
        </form>
        <a href="contacts">contacts</a>
    </body>
</html>
