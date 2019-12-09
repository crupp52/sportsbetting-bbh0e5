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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Főoldal <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Nyelv
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">English</a>
                    <a class="dropdown-item" href="#">Magyar</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class="container">

    <main>
        <div class="card m-3">
            <div class="card-header">
                Account details
            </div>
            <div class="card-body">
                <form action="home/save" method="post">
                    <div class="form-group row">
                        <div class="col">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">Name</div>
                                </div>
                                <input id="name" name="name" placeholder="John Golden" type="text" class="form-control"
                                       value="${user.getName()}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">Birth date</div>
                                </div>
                                <input id="birth-date" name="birth-date" placeholder="1976-01-01" type="text"
                                       class="form-control" value="${user.getBirth()}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">Account number</div>
                                </div>
                                <input id="account-number" name="account-number" placeholder="12345678-12345678"
                                       type="text" class="form-control" value="${user.getAccountNumber()}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">Currency</div>
                                </div>
                                <input id="currency" name="currency" placeholder="USD" type="text" class="form-control"
                                       value="${user.getCurrency()}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">Balance</div>
                                </div>
                                <input id="balance" name="balance" placeholder="5000" type="text" class="form-control"
                                       value="${user.getBalance()}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col">
                            <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="card m-3">
            <div class="card-header">
                Wagers
            </div>
            <div class="card-body">
                <table id="wager-table" class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Event title</th>
                        <th>Event type</th>
                        <th>Bet type</th>
                        <th>Outcome value</th>
                        <th>Outcome odd</th>
                        <th>Wager amount</th>
                        <th>Winner</th>
                        <th>Processed</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%--                    <tr>--%>
                    <%--                        <th scope="row">1</th>--%>
                    <%--                        <td>MTK-FTC - 2019.10.10.</td>--%>
                    <%--                        <td>Football Match</td>--%>
                    <%--                        <td>Winner</td>--%>
                    <%--                        <td>MTK</td>--%>
                    <%--                        <td>1:2</td>--%>
                    <%--                        <td>10000</td>--%>
                    <%--                        <td>Yes</td>--%>
                    <%--                        <td>No</td>--%>
                    <%--                        <td>--%>
                    <%--                            <a href="#">--%>
                    <%--                                <button class="btn btn-danger">Remove</button>--%>
                    <%--                            </a>--%>
                    <%--                        </td>--%>
                    <%--                    </tr>--%>
                    <c:forEach items="${wagers}" var="wager">
                        <tr>
                            <td>
                                    ${wager.getId()}
                            </td>
                            <td>
                                    ${wager.getEventTitle()}
                            </td>
                            <td>
                                    ${wager.getEventType()}
                            </td>
                            <td>
                                    ${wager.getBetType()}
                            </td>
                            <td>
                                    ${wager.getOutcomeValue()}
                            </td>
                            <td>
                                    ${wager.getOutcomeOdd()}
                            </td>
                            <td>
                                    ${wager.getWagerAmount()}
                            </td>
                            <td>
                                    ${wager.getWinner()}
                            </td>
                            <td>
                                    ${wager.getProcessed()}
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${!wager.isProcessed()}">
                                        <a href="home/delete?id=${wager.getId()}">
                                            <button class="btn btn-danger" type="submit">Remove</button>
                                        </a>
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</div>
</body>
</html>