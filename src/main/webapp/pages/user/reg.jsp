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
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="row justify-content-center">
    <div class="container">
        <form action="/registration" method="post">
            <h3><label><input type="text" name="name" placeholder="Name"></label> Name</h3>
            <br>
            <h3><label><input type="text" name="username" placeholder="Username"></label> Username</h3>
            <br>
            <h3><label><input type="text" name="password" placeholder="Password"></label> Password</h3>
            <br>
            <br>
            <button><h3>Submit</h3></button>
            <br>
            <br>
        </form>
    </div>
</div>
<h3>Registration</h3>
<a href="/"><h3>Back</h3></a>
<p>
<h3>${requestScope.messageErrorRegistration}</h3></p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>



