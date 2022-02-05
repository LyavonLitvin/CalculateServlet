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
<form action="/history" method="post">
    <h3>Results history for current user:</h3>
    <br>
    <br>
    <ol>
        <c:forEach var="result" items="${results}">
            <li><h3> calculation: ${result.toString()}/></h3></li>
        </c:forEach>
    </ol>
    <hr>
    <br>
    <h3><a href="/calc">Calculator</a></h3>
    <br>
    <h3><a href="/">On the main page</a></h3>
    <br>
    <br>
</form>
<h3><p>${requestScope.messageErrorHistory}</p></h3>
<form action="/logout" method="post">
    <button>Logout</button>
</form>
</body>
</html>


