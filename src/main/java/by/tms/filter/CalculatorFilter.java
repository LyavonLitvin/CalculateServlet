package by.tms.filter;

import by.tms.service.InMemoryUsersStorageService;
import by.tms.validator.CalculatorValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "CalcServlet")
public class CalculatorFilter extends HttpFilter {
    InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {

        CalculatorValidator validator = new CalculatorValidator();
        if (req.getMethod().equals("POST")) {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") == null) {
                req.setAttribute("messageErrorCalculator", "You have to authorize first!");
                System.out.println("You have to authorize first!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            } else if (!inMemoryUsersStorageService.checkUser((String) session.getAttribute("username"))) {
                req.setAttribute("messageErrorCalculator", "You have to authorize first!");
                System.out.println("You have to authorize first!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            } else {
                String firstNumberString = req.getParameter("num1");
                String secondNumberString = req.getParameter("num2");
                String operationType = req.getParameter("opType");
                if (firstNumberString == null || secondNumberString == null || operationType == null) {
                    req.setAttribute("messageErrorCalculator", "One of the fields is null!");
                    System.out.println("One of the fields is null!");
                    req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
                } else if (firstNumberString.isEmpty() || secondNumberString.isEmpty() || operationType.isEmpty()) {
                    req.setAttribute("messageErrorCalculator", "One of the fields is empty!");
                    System.out.println("One of the fields is empty!");
                    req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
                } else if (!validator.isNumeric(firstNumberString) && !validator.isNumeric(secondNumberString) && !validator.isRightOperator(operationType)) {
                    req.setAttribute("messageErrorCalculator", "Wrong enter numbers or opType");
                    System.out.println("Wrong enter numbers or opType");
                    req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
                }
            }
        }
        chain.doFilter(req, resp);
    }
}

// <p>${requestScope.message}</p>