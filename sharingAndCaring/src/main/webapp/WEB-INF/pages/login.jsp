<%--
  Created by IntelliJ IDEA.
  User: ajantha
  Date: 12/28/15
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <title></title>
  <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
  <link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
  <link rel="stylesheet" href="resources/css/loginpage.css">
</head>
<body>


<div class="wrapper">



  <form class="form-signin" name='loginForm'
        action="<c:url value='login'/>" method='POST'>

    <h2 class="form-signin-heading">Please login</h2>

    <c:if test="${not empty error}"><div class="text-danger">${error}</div></c:if>
    <c:if test="${not empty message}"><div class="text-success">${message}</div></c:if>

    <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
    <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
    <label class="checkbox">
      <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
    </label>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
  </form>
</div>
</body>
</html>
