package by.tms.filter;

import by.tms.service.CalculatorService;
import by.tms.service.InMemoryUsersStorageService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "HistoryServlet")
public class HistoryFilter extends HttpFilter {
    InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            System.out.println("testDoFilter");
            HttpSession session = req.getSession();
            if (session.getAttribute("username") == null) {
                req.setAttribute("messageErrorHistory", "You have to authorize first!");
                System.out.println("You have to authorize first!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);

            }
        }
//        } else {
//            session.setAttribute("messageErrorHistory", "You have to authorize first!");
//            System.out.println("You have to authorize first!");
//
//        }
        chain.doFilter(req, resp);
    }
}