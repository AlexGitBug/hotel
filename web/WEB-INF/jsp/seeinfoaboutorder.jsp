<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>Info about order</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Информация о заказах</h1>

<ul>
  <c:forEach var="order" items="${requestScope.order}">
    <li>
        ${order.id} - ${requestScope.order.beginTimeOfTheOrder} - ${requestScope.order.endTimeOfTheOrder}
    </li>
  </c:forEach>
</ul>
<%--<form action="${pageContext.request.contextPath}/client_bookings" method="get">--%>
<%--  <button type="submit"><fmt:message key="page.seeBooking.button.back" /></button>--%>
<%--</form>--%>
</body>
</html>


