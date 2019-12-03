<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sportsbetting - Spring MVC</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.4.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Welcome to Sportsbetting Service!</h1>
            <p class="lead">Log in to access the amazing functions.</p>
            <p class="lead">
                <a class="btn btn-primary btn-lg" href="login" role="button">Login</a>
            </p>
        </div>
    </div>
</body>
</html>
