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
<h3>Calculation</h3>
<form action="/calc" method="post">
    <h3><label><input type="text" name="num1" placeholder="num1" required></label>Number 1</h3>
    <select name="opType">
        <option disabled selected><h3>Select operation</h3></option>
        <option value="sum"><h3>+</h3></option>
        <option value="div"><h3>/</h3></option>
        <option value="diff"><h3>-</h3></option>
        <option value="multiple"><h3>*</h3></option>
    </select>
    <h3><label><input type="text" name="num2" placeholder="num2" required></label>Number 2</h3>
    <button><h3>Calculate</h3></button>
    <br>
</form>
<h3><p>Calculation: ${requestScope.messageCalculator}</p></h3>
<br>
<h3><a href="/history"><h3>Show operations history</h3></a></h3>
<br>
<h3><a href="/"><h3>On the main page</h3></a></h3>
<br>
<form action="/logout" method="post">
    <button>Logout</button>
</form>
<br>
<h3><p>${requestScope.messageErrorCalculator}</p></h3>
</body>
</html>
