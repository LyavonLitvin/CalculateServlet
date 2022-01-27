package by.tms.servlet;

import by.tms.entity.Result;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/history", name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CalculatorService calculatorService = new CalculatorService();
        System.out.println("testDoGet");
        for ( Result result1: calculatorService.getResultsToSOUT((String) session.getAttribute("username"))) {
            System.out.println(result1.toString());
        }
        ArrayList<String> results = calculatorService.getResults((String) session.getAttribute("username"));
        req.setAttribute("results", results);
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}
