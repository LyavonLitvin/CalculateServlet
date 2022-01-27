package by.tms.entity;

public class Result {
    private double firstNumber;
    private double secondNumber;
    private String operatorType;
    private double resultNumber;
    private String userName;

    public Result() {
    }

    public Result(double firstNumber, double secondNumber, String operatorType, String userName) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.userName = userName;
    }

    public Result(double firstNumber, double secondNumber, String operatorType, double resultNumber, String userName) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return " " + firstNumber + " " + operatorType + " " + secondNumber + " = " + resultNumber + " ";
    }
}
