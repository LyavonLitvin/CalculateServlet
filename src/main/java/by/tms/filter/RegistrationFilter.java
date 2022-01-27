package by.tms.filter;

import by.tms.service.InMemoryUsersStorageService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {
    InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String name = req.getParameter("name");
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            if (name == null || userName == null || password == null) {
                req.setAttribute("messageErrorRegistration", "name or username or password is null!");
                System.out.println("name or username or password is null!");
                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
            } else if (name.isEmpty() || userName.isEmpty() || password.isEmpty()) {
                req.setAttribute("messageErrorRegistration", "name or username or password is empty!");
                System.out.println("name or username or password is empty!");
                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
            } else if (inMemoryUsersStorageService.checkUser(userName)) {
                req.setAttribute("messageErrorRegistration", "User has found! Try to authorize!");
                System.out.println("User has found! Try to authorize!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            }
        }
        chain.doFilter(req, resp);
    }
}
