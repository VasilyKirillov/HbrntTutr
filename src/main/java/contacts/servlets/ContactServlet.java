package contacts.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contacts.entities.Address;
import contacts.entities.Contact;
import contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(id);
            request.setAttribute("contact", contact);
            if (request.getParameter("edit") != null) {
                request.getRequestDispatcher("jsp/editContact.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/viewContact.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("add") != null) {
            
            Contact contact = new Contact(request.getParameter("name"), 
                    new Address(request.getParameter("street"), request.getParameter("city"), request.getParameter("state"), request.getParameter("zip")));
            contact = contactRepository.save(contact);
            response.sendRedirect("contact?id=" + contact.getId());
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.find(id);
            
            if (request.getParameter("edit") != null) {
                contact.setName(request.getParameter("name"));
                Address address = contact.getAddress();
                address.setStreet(request.getParameter("street"));
                address.setCity(request.getParameter("city"));
                address.setState(request.getParameter("state"));
                address.setZip(request.getParameter("zip"));
                contactRepository.save(contact);                

                response.sendRedirect("contact?id=" + contact.getId());
            } else if (request.getParameter("del") != null) {
                contactRepository.delete(contact);
                
                response.sendRedirect("contacts");
            } else {
                super.doPost(request, response);
            }
        }

    }

}
