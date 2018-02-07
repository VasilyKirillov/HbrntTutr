
package servlets;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.ContactRepository;

@WebServlet("contacts")
public class ContactListServlet extends HttpServlet{

    private ContactRepository contactRepository = new ContactRepository();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("contacts", contactRepository.findAll());
            req.getRequestDispatcher("/jsp/contactList.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServerException("repository exception: ", ex);
        }
    }
    
}
