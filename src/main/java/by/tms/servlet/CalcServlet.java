package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import by.tms.service.*;
import by.tms.entity.Result;

@WebServlet(urlPatterns = "/calc", name = "CalcServlet")
public class CalcServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        CalculatorService calculatorService = new CalculatorService();
        HttpSession session = req.getSession();
        String firstNumberString = req.getParameter("num1");
        String secondNumberString = req.getParameter("num2");
        String operationType = req.getParameter("opType");
        double firstNumber = Double.parseDouble(firstNumberString);
        double secondNumber = Double.parseDouble(secondNumberString);
        Result result = new Result(firstNumber, secondNumber, operationType, (String) session.getAttribute("username"));
        calculatorService.calculation(result);
        System.out.println("Calculation was successful");
        req.setAttribute("results",calculatorService.getResults((String) session.getAttribute("username")));
        req.setAttribute("messageCalculation", result.toString());
        for ( Result result1: calculatorService.getResultsToSOUT((String) session.getAttribute("username"))) {
            System.out.println(result1.toString());
        }
        req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}
