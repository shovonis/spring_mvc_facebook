<%--
  Created by IntelliJ IDEA.
  User: rifatul.islam
  Date: 6/22/14
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Profile Details</h3>
            </div>
            <div class="panel-body">
                <div class="col-lg-6">
                    <form:form class="form-horizontal" action="update" commandName="profile" method="post">
                        <fieldset>
                            <legend>Registration Form</legend>
                            <div class="form-group">
                                <label for="inputEmail" class="col-lg-2 control-label">Email</label>

                                <div class="col-lg-10">
                                    <form:input readonly="true" path="email" type="text" class="form-control"
                                                id="inputEmail"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword" class="col-lg-2 control-label">Password</label>

                                <div class="col-lg-10">
                                    <form:input readonly="true" type="password" path="password" class="form-control"
                                                id="inputPassword"/>
                                </div>
                                <br/><br/>
                            </div>

                            <div class="form-group">
                                <label for="firstName" class="col-lg-2 control-label">First Name</label>

                                <div class="col-lg-10">
                                    <form:input readonly="false" type="text" path="userDetails.firstName"
                                                class="form-control"
                                                id="firstName"/>
                                </div>

                            </div>

                            <div class="form-group">
                                <label for="lastName" class="col-lg-2 control-label">First Name</label>

                                <div class="col-lg-10">
                                    <form:input readonly="false" type="text" path="userDetails.lastName"
                                                class="form-control"
                                                id="lastName"/>
                                </div>

                            </div>


                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button class="btn btn-default">Update</button>

                                </div>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
