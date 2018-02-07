package contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.entities.Address;
import contacts.entities.Contact;
import contacts.repositories.AddressRepository;
import contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final AddressRepository addressRepository = new AddressRepository();
    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("add") != null) {
                request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);
            } else {
                long id = Long.parseLong(request.getParameter("id"));
                Contact contact = contactRepository.find(id);
                Address address = addressRepository.find(contact.getAddressId());
                request.setAttribute("contact", contact);
                request.setAttribute("address", address);
                if (request.getParameter("edit") != null) {
                    request.getRequestDispatcher("jsp/editContact.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("jsp/viewContact.jsp").forward(request, response);
                }
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("add") != null) {
                Address address = new Address(request.getParameter("street"), request.getParameter("city"), request.getParameter("state"), request.getParameter("zip"));
                addressRepository.create(address);
                Contact contact = new Contact(request.getParameter("name"), address.getId());
                contactRepository.create(contact);
                response.sendRedirect("contact?id=" + contact.getId());
            } else {
                long id = Long.parseLong(request.getParameter("id"));
                Contact contact = contactRepository.find(id);
                Address address = addressRepository.find(contact.getAddressId());
                if (request.getParameter("edit") != null) {
                    contact.setName(request.getParameter("name"));
                    address.setStreet(request.getParameter("street"));
                    address.setCity(request.getParameter("city"));
                    address.setState(request.getParameter("state"));
                    address.setZip(request.getParameter("zip"));
                    contactRepository.update(contact);
                    addressRepository.update(address);

                    response.sendRedirect("contact?id=" + contact.getId());
                } else if (request.getParameter("del") != null) {
                    contactRepository.delete(contact);
                    addressRepository.delete(address);
                    response.sendRedirect("contacts");
                } else {
                    super.doPost(request, response);
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}
