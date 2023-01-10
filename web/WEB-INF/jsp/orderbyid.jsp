<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Заказ</title>
</head>
<body>
<h1>Заказ:</h1>
<ul>
    <c:forEach var="order" items="${requestScope.orderlist}">
        <ul>
           Order ID: ${order.id}<br>
            или любая другая информация<br>
        </ul>
    </c:forEach>
</ul>
</body>
</html>
