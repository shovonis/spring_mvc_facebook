<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title><decorator:title/></title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" media="all">


    <decorator:head/>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<decorator:body/>
</body>
</html>