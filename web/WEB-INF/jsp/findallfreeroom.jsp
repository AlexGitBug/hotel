<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>All rooms</title>
</head>
<body>

<%@include file="header.jsp" %>
_____________________________________________________________________________
<form action="/findallfreeroom" method="get" enctype="multipart/form-data">
    <label><br>
        <h1><fmt:message key="page.findallfreeroom.List of all free room"/></h1>
        <ul><c:forEach var="room" items="${requestScope.freeroom}">
            <li>
                <img width="210" height="170" src="${pageContext.request.contextPath}/users/users${room.image}" alt="No image"><br>
                <a href="/room?id=${room.id}"><fmt:message key="page.findallfreeroom.Description room"/>: ${room.number} - ${room.status}</a>
            </li>
        </c:forEach>
        </ul>
    </label>
</form><br>
<%--<form action="${pageContext.request.contextPath}/order" method="get">--%>
<%--  <button type="submit">Back to make a new order</button>--%>
<%--</form>--%>
_____________________________________________________________________________
<br>
<%@include file="footer.jsp" %>
</body>
</html>