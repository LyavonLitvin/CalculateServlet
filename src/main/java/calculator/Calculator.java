package calculator;

public class Calculator {
    public Calculator() {
    }

    public Result calculation(Result result) {
        double a = result.getFirstNumber();
        double b = result.getSecondNumber();
        double resultNumber = 0;
        String controlLetter = result.getOperatorType();
        if (controlLetter.equals("sum")) {
            Sum sum = new Sum();
            resultNumber = sum.operation(a, b);
        } else if (controlLetter.equals("diff")) {
            Diff diff = new Diff();
            resultNumber = diff.operation(a, b);
        } else if (controlLetter.equals("multiple")) {
            Multiple multiple = new Multiple();
            resultNumber = multiple.operation(a, b);
        } else if (controlLetter.equals("div")) {
            Div div = new Div();
            resultNumber = div.operation(a, b);
        }
        result.setResultNumber(resultNumber);
        return result;
    }
}


