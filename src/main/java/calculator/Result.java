package calculator;

public class Result {
    private double firstNumber;
    private double secondNumber;
    private String operatorType;
    private double resultNumber;

    public Result() {
    }

    public Result(double firstNumber, double secondNumber, String operatorType) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
    }

    public Result(double firstNumber, double secondNumber, String operatorType, double resultNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public double getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
    }

    @Override
    public String toString() {
        return "Result = "+ resultNumber;
    }
}
