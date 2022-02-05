<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Created by IntelliJ IDEA.
User: User
Date: 25.01.2022
Time: 20:22
To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${sessionScope.username == null}">
        <title>Welcome to Calculator! Authorization or Registration page</title>
    </c:if>
    <c:if test="${sessionScope.username != null}">
        <title>Calculation page</title>
    </c:if>

    <%--        /*.my-button{*/--%>
    <%--        /*    color: aquamarine;*/--%>
    <%--        /*    background-color: blue;*/--%>
    <%--        /*}*/--%>
<%--    <link rel="stylesheet" href="styles.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<br>
<c:if test="${sessionScope.username == null}">
    <h1>Welcome to Calculator!</h1>
    <a href="/registration"><h3>Registration</h3></a>
    <a href="/authorization"><h3>Authorization</h3></a>
</c:if>
<c:if test="${sessionScope.username != null}">
    <a href="/calc"><h3>Calculator</h3></a>
    <a href="/history"><h3>Show operations history</h3></a>
    <form action="/logout" method="post">
        <button class="my-button">Logout</button>
    </form>
</c:if>
<br>
<p>
<h3>${requestScope.messageLogout}</h3></p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

