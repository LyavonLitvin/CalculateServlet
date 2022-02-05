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
<h3>Authorization</h3>
<form action="/authorization" method="post">
    <h3><label><input type="text" name="username" placeholder="Username"></label> Username</h3>
    <br>
    <h3><label><input type="text" name="password" placeholder="Password"></label> Password</h3>
    <br>
    <button><h3>Submit</h3></button>
    <br>
    <br>
    <p>
    <h3>${requestScope.messageErrorAuthorization}</h3>
    </p>
</form>
<br>
<a href="/"><h3>Back</h3></a>
</body>
</html>
