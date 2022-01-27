package by.tms.servlet;

import by.tms.service.CalculatorService;
import by.tms.service.InMemoryUsersStorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout", name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();
        InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();
        HttpSession session = req.getSession();
        calculatorService.deleteResults();
        System.out.println("Results have deleted successfully");
        inMemoryUsersStorageService.deleteUsers();
        System.out.println("Users have deleted successfully");
        session.removeAttribute("username");
        session.invalidate();
        resp.getWriter().println("Logout successfully");
        System.out.println("Logout successfully");
        //req.getServletContext().getRequestDispatcher("/pages/logout.jsp").forward(req, resp);
    }
}
