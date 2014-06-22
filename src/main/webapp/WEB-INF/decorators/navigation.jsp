<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rifatul.islam
  Date: 6/22/14
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="home">Mini Facebook</a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <c:if test="${sessionScope.user ne null}">
                <li><a href="home">Home</a></li>
                <li><a href="profile">Profile</a></li>
            </c:if>
        </ul>
        <form class="navbar-form navbar-left">
            <input type="text" class="form-control col-lg-8" placeholder="Search User">
        </form>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${sessionScope.user ne null}">
                <li><a href="#">Notification</a></li>
                <li><a href="logout">Logout</a></li>
            </c:if>
        </ul>
    </div>
</div>
</body>
</html>
