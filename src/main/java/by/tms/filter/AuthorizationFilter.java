package by.tms.filter;

import by.tms.service.InMemoryUsersStorageService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "AuthorizationServlet")
public class AuthorizationFilter extends HttpFilter {
    InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            if (userName == null || password == null ) {
                req.setAttribute("messageErrorAuthorization", "session or username or password is empty!");
                System.out.println("username or password is null!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            } else if (userName.isEmpty() || password.isEmpty()) {
                req.setAttribute("messageErrorAuthorization", "username or password is empty!");
                System.out.println("username or password is empty!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            } else if (!inMemoryUsersStorageService.checkUser(userName)) {
                req.setAttribute("messageErrorAuthorization", "User not found!");
                System.out.println("User not found!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            } else if (!inMemoryUsersStorageService.checkUserByUsernamePassword(userName, password)) {
                req.setAttribute("messageErrorAuthorization", "Password is incorrect!");
                System.out.println("Password is incorrect!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            }
        }
        chain.doFilter(req, resp);
    }
}
