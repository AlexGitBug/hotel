<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Заказы</title>
</head>
<body>
<form action="/order" method="post">
    <%--  <select name="role" id="role">--%>
    <%--    <c:forEach var="role" items="${requestScope.roles}">--%>
    <%--      <option value="${role.id}">${role.rank}</option>--%>
    <%--    </c:forEach>--%>
    <%--  </select><br>--%>
    <label>Список комнат:
        <select name="roomid" id="roomid">
            <c:forEach var="roomid" items="${requestScope.roomid}">
                <option value="${roomid}">${roomid}</option>
            </c:forEach>
        </select>
    </label><br>
    <%--  &lt;%&ndash;  <label for="userinfoid">User id:&ndash;%&gt;--%>
    <%--  &lt;%&ndash;    <input type="text" name="userinfoid" id="userinfoid">&ndash;%&gt;--%>
    <%--  &lt;%&ndash;  </label><br>&ndash;%&gt;--%>
    <%--  <label for="roomid">Room id:--%>
    <%--    <input type="text" name="roomid" id="roomid">--%>
    <%--  </label><br>--%>
    <label for="begintime">Begin Time:
        <input type="date" name="begintime" id="begintime">
    </label><br>
    <label for="endtime">End Time:
        <input type="date" name="endtime" id="endtime">
    </label><br>
    <label for="condition">Condition:
        <input type="text" name="condition" id="condition">
    </label><br>Message:
    <label for="message">
        <input type="text" name="message" id="message">
    </label><br>
    <%--  Role:--%>
    <%--  <select name="role" id="role">--%>
    <%--    <c:forEach var="role" items="${requestScope.roles}">--%>
    <%--      <option value="${role.id}">${role.rank}</option>--%>
    <%--    </c:forEach>--%>
    <%--  </select><br>--%>
    <button type="submit">Send</button>
</form>
</body>
</html>
