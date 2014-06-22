<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="well"></div>
        <div class="col-lg-6">
            <form:form class="form-horizontal" action="register" commandName="user" method="post">
                <fieldset>
                    <legend>Registration Form</legend>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Email</label>

                        <div class="col-lg-10">
                            <form:input path="email" type="text" class="form-control" id="inputEmail"
                                        placeholder="Email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>

                        <div class="col-lg-10">
                            <form:input type="password" path="password" class="form-control" id="inputPassword"
                                        placeholder="Password"/>
                        </div>
                        <br/><br/>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button class="btn btn-default">Register</button> Or  <label>
                            <a href="login"> Sign in</a>
                        </label>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
