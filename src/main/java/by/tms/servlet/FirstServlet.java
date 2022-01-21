package by.tms.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import calculator.*;
import calculator.validator.Validator;

@WebServlet(urlPatterns = "/calc")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException {
        Validator validator = new Validator();
        Calculator calculator = new Calculator();
        String firstNumberString = req.getParameter("num1");
        String secondNumberString = req.getParameter("num2");
        String operationType = req.getParameter("opType");
        if (validator.isNumeric(firstNumberString) && validator.isNumeric(secondNumberString) && validator.isRightOperator(operationType)) {
            double firstNumber = Double.parseDouble(firstNumberString);
            double secondNumber = Double.parseDouble(secondNumberString);
            Result result = new Result();
            result.setFirstNumber(firstNumber);
            result.setSecondNumber(secondNumber);
            result.setOperatorType(operationType);
            calculator.calculation(result);
            resp.getWriter().println(result);
        } else {
            resp.getWriter().println("Wrong enter numbers or opType");
        }


    }
}
