<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#954f59">
        <h1>Hello, ${empty id ? 'World' : id}! </h1>

        <%-- //scriplet example
            repositories.AddressRepository addressRepo =
                new repositories.AddressRepository();
        try {
            addressRepo.init();
            model.Address address = new model.Address("Lesnaia respublika", "Saratov", null, "410065");
            addressRepo.create(address);
            System.out.println("*******************: " + addressRepo.find(address.getId()));
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        } --%>

        
    </body>
</html>
