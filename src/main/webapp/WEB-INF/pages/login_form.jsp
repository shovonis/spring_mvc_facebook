<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<%--<form action="login" method="post" class="form-horizontal">--%>
<%--<h1>Mini Facebook Login--%>
<%--<span>Please Login</span>--%>
<%--</h1>--%>
<%--<label>--%>
<%--<span>User Name :</span>--%>
<%--<input id="name" type="text" name="userName" placeholder="user name"/>--%>
<%--</label>--%>

<%--<label>--%>
<%--<span>Password :</span>--%>
<%--<input id="email" type="password" name="password" placeholder="password"/>--%>
<%--</label>--%>
<%--<label>--%>
<%--<span>&nbsp;</span>--%>
<%--<input type="submit" class="button" value="Login"/>--%>
<%--</label>--%>
<%--</form>--%>

<div class="container">
    <div class="row">
        <div class="well"></div>
        <div class="col-lg-6">
            <form class="form-horizontal" action="login" method="post">
                <fieldset>
                    <legend>Login Form</legend>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>

                        <div class="col-lg-10">
                            <input type="text" name="userName" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>

                        <div class="col-lg-10">
                            <input type="password" name="password" class="form-control" id="inputPassword"
                                   placeholder="Password">

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Remember me
                                </label>
                            </div>

                            <label>
                                <a href="signup">New User? Sign Up</a>
                            </label>

                            <div class="col-sm-offset-11 ">
                                <button type="submit" class="btn btn-primary">Login</button>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>
