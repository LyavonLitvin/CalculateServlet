<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.01.2022
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
<form action="/calc" method="post">
    <label><input type="text" name="num1" placeholder="num1"></label>Number 1
    <br>
    <br>
    <label><input type="text" name="num2" placeholder="num2"></label>Number 2
    <br>
    <br>
    <label><input type="text" name="opType" placeholder="opType"></label>Operation Type
    <br>
    <br>
    <button>Calculate</button>
    <br>
    <h3><p>Calculation: ${requestScope.messageCalculator}</p></h3>
    <br>
    <br>
    <a href="/history"><h3>Show operations history</h3></a>
    <br>
    <br>
    <a href="/"><h3>On the main page</h3></a>
    <br>
    <br>
    <a href="/logout"><h3>Logout</h3></a>
    <br>
    <br>
    <p>${requestScope.messageErrorCalculator}</p>
</form>
</body>
</html>
