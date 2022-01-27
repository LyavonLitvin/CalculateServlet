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
    <br>
    <br>
    <br>
    <button formaction="/pages/history.jsp">Show operations history</button>
    <br>
    <br>
    <button formaction="/pages/index.jsp">On the main page</button>
    <br>
    <br>
    <a href="/logout"><h3>Logout</h3></a>
    <br>
    <p>Calculation:</p>${requestScope.messageCalculator}
    <br>
    <p>${requestScope.messageErrorCalculator}</p>
</form>
</body>
</html>
