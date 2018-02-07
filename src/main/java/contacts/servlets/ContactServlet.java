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
		if (request.getParameter("add") != null) {
			request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);
		} else {
			// TODO
			super.doGet(request, response);
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
				response.sendRedirect("contacts");
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
