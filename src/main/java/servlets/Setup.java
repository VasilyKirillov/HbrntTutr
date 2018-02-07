
package servlets;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import model.Address;
//import model.Contact;
import repositories.AddressRepository;
import repositories.ContactRepository;


public class Setup implements ServletContextListener{
private static final Logger LOGGER = Logger.getLogger(Setup.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AddressRepository addressRepo = new AddressRepository();
        ContactRepository contactRepo = new ContactRepository();
        try {
            addressRepo.init();
//            addressRepo.create(new Address("garden avenue", "heaven realm", "paradize", "0" ));
            contactRepo.init();
//            contactRepo.create(new Contact("Adam", 0L));
//            contactRepo.create(new Contact("Eve", address.getId()));
//            contactRepo.create(new Contact("Snake", address.getId()));
//            contactRepo.create(new Contact("God", address.getId()));
//            contactRepo.create(new Contact("Apple", address.getId()));
//            Address address = new Address("Lesnaia respublika", "Saratov", null, "410065");
//            addressRepo.create(address);
//            System.out.println("*******************: " + addressRepo.find(address.getId()));
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "setup", ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         // dont care
    }
    
}
