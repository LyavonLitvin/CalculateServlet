package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.InMemoryUsersStorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setAttribute("username", userName);
        session.setAttribute("password", password);
        System.out.println("Authorization was successful.");
        System.out.println("Users");
        for (User user: inMemoryUsersStorageService.getUsers()) {
            System.out.println(user.toString());
        }
        req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

}
