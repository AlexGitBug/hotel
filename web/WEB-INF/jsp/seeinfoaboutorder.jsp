<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>Info about order</title>
</head>
<body>
<%@ include file="header.jsp" %><br>
_____________________________________________________________________________
<h1>Информация о заказах</h1>
<ul>
  ${requestScope.order.id} - ${requestScope.order.beginTimeOfTheOrder} - ${requestScope.order.endTimeOfTheOrder}
</ul>
<form action="${pageContext.request.contextPath}/userorderlist" method="get">
  <button type="submit">Back</button>
</form>
</body>
</html>

