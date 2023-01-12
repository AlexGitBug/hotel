<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Заказ</title>
</head>
<body>
<h1>Order</h1>

<ul>
    <b>Order description:</b><br>
    Order Id: ${requestScope.order.id}<br>
    User Id: ${requestScope.order.userInfo}<br>
    Room Id: ${requestScope.order.room}<br>
    Begin time: ${requestScope.order.beginTimeOfTheOrder}<br>
    End time: ${requestScope.order.endTimeOfTheOrder}<br>
    Condition: ${requestScope.order.condition}<br>
    Message: ${requestScope.order.message}<br>
</ul>
<br>
<ul>
    <b>User description</b>

</ul>

<c:if test="${requestScope.booking.status != 'WANT_TO_RESERVE'}">
<form action="${pageContext.request.contextPath}/messageforadmintocancel" method="get">
    <button type="submit" name="orderId" value="${order.id}">Send message for admin</button>
</form>
</c:if>

</body>
</html>
<%--<ul>--%>
<%--    ${requestScope.order.userInfo} - ${requestScope.order.room} - ${requestScope.order.beginTimeOfTheOrder} - ${requestScope.order.endTimeOfTheOrder} -${requestScope.order.condition} - ${requestScope.order.message}--%>
<%--</ul>--%>

<%--<form action="${pageContext.request.contextPath}/checkorder" method="get">--%>
<%--    <button type="submit" name="orderId" value="${requestScope.order.id}"><fmt:message key="page.checkorder.Check"/></button>--%>
<%--</form>--%>
<%--<form action="${pageContext.request.contextPath}/checkorderbookedfree" method="get">--%>
<%--    <button type="submit" name="orderId" value="${requestScope.order.id}"><fmt:message key="page.checkorder.Change status from booked for free"/> </button>--%>
<%--</form>--%>
<%--</form>--%>