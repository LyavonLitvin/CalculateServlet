package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import by.tms.entity.User;
import by.tms.service.InMemoryUsersStorageService;

//registration?name=leo&username=leo&password=leo
@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        session.setAttribute("username", userName);
        User user = new User(name, userName, password, session.getId());
        if (inMemoryUsersStorageService.saveUser(user)) {
            session.setAttribute("messageErrorRegistration","Registration was successful.");
            req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
        } else {
            session.setAttribute("messageErrorRegistration","Error. User not created.");
            req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
        }
    }
}
