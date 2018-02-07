
package servlets;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.Address;
import repositories.AddressRepository;

/**
 *
 * @author Administrator
 */
public class Setup implements ServletContextListener{
private static final Logger LOGGER = Logger.getLogger(Setup.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AddressRepository addressRepo = new AddressRepository();
        try {
            addressRepo.init();
            Address address = new Address("Lesnaia respublika", "Saratov", null, "410065");
            addressRepo.create(address);
            System.out.println("*******************: " + addressRepo.find(address.getId()));
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         // dont care
    }
    
}
