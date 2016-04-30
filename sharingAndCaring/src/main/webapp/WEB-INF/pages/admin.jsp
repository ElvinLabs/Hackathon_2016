<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>
<h1>role : ${role}</h1>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h2>Welcome : ${pageContext.request.userPrincipal.name}
    | <a href="<c:url value="logout" />" > Logout</a></h2>mvn
</c:if>
</body>
</html>


