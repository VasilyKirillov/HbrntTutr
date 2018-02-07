package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import model.Contact;
import repositories.AddressRepository;
import repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    private ContactRepository contactRepository;
    private AddressRepository addressRepository;

    @Override
    public void init() throws ServletException {
        contactRepository = new ContactRepository();
        addressRepository = new AddressRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            String name = req.getParameter("name");
            String street = req.getParameter("street");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String zip = req.getParameter("zip");

            try {
                Address address = new Address(street, city, state, zip);
                addressRepository.create(address);
                Contact contact = new Contact(name, address.getId());
                contactRepository.create(contact);

                resp.sendRedirect("contacts");
            } catch (SQLException ex) {
                throw new ServletException("repository exeption", ex);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            req.getRequestDispatcher("jsp/addContact.jsp").forward(req, resp);
        } else {
            super.doGet(req, resp);
        }
    }

}
