
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("hello-servlet")
public class HelloWorld extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("jsp/hello.jsp"); //use user browser to change page
        req.getRequestDispatcher("/jsp/hello.jsp").forward(req, resp); //change page on the server side
    }
    
}
