<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Комнат:</title>
</head>
<body>
<h1>Комната номер :</h1>
<ul>
    <c:forEach var="room" items="${requestScope.roomlist}">
        <jsp:text>

        </jsp:text>Номер комнаты: ${room.number}<br>
        <h1>Этаж: ${room.floor}</h1><br>
        <h1>Стоимость за сутки: ${room.dayPrice}</h1><br>
    </c:forEach>
</ul>
</body>
</html>
<%--int id;--%>
<%--NumberRoomEnum number;--%>
<%--QuantityBed quantityBed;--%>
<%--CategoryRoom categoryRoom;--%>
<%--int floor;--%>
<%--int dayPrice;--%>
<%--RoomStatusEnum status;--%>
