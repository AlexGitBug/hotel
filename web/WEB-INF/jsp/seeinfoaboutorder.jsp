<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>All my orders</title>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
_____________________________________________________________________________
<h1><fmt:message key="page.seeinfoaboutorder.orders"/></h1>
<ul>
  <c:forEach var="userorderlist" items="${requestScope.userorderlist}">
    <ul>
      <a href="${pageContext.request.contextPath}/orderbyid?id=${userorderlist.id}">
        Order id: ${userorderlist.id}, User id: ${userorderlist.userInfo}, Room id: ${userorderlist.room},
        Begin time: ${userorderlist.beginTimeOfTheOrder}, End time: ${userorderlist.endTimeOfTheOrder},
        Condition: ${userorderlist.condition}, Message: ${userorderlist.message}

    </ul>
  </c:forEach>
</ul><br>
<form action="${pageContext.request.contextPath}/download_user_report" method="get">
  <button type="submit"><fmt:message key="page.seeinfoaboutorder.submit.button.Download my orders"/>Download my orders</button>
</form>
_____________________________________________________________________________
<%@include file="footer.jsp" %>
</body>
</html>


<%--<li>--%>
<%--  <a href="${pageContext.request.contextPath}/checkorder">--%>
<%--    Order id: ${order.id}, User id: ${order.userInfo}, Room id: ${order.room},--%>
<%--    Begin time: ${order.beginTimeOfTheOrder}, End time: ${order.endTimeOfTheOrder},--%>
<%--    Condition: ${order.condition}, Message: ${order.message}--%>
<%--  </a>--%>
<%--</li>--%>


