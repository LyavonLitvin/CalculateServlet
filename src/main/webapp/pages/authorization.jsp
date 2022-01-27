<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.01.2022
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<h4>Authorization</h4>
<form action="/authorization" method="post">
    <label><input type="text" name="username" placeholder="Username"></label>Username
    <br>
    <label><input type="text" name="password" placeholder="Password"></label>Password
    <br>
    <br>
    <button>Submit</button>
    <br>
    <br>
    <button formaction="/pages/index.jsp">On the main page</button>
    <br>
    <p>${requestScope.messageErrorAuthorization}</p>
</form>
<br>
</body>
</html>
