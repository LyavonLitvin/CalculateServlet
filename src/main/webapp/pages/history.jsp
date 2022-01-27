<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.01.2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Results history for current user</title>
</head>
<body>
<form action="/history" method="post">  <%--  --%>
    <h3>Results history for current user:</h3>
    <br>
    <br>
    <c:forEach var="result" items="${results}">
        <ul>
            <li> result: <c:out value="${result}"/></li>
        </ul>
        <hr>
    </c:forEach>
    <br>
    <br>
    <button formaction="/pages/calc.jsp">Calculation</button>
    <br>
    <br>
    <button formaction="/pages/index.jsp">To the main page</button>
    <br>
    <br>
    <a href="/logout"><h3>Logout</h3></a>
    <br>
    <br>
    <p>${requestScope.messageErrorHistory}</p>
</form>
</body>
</html>
