<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Заказы</title>
</head>
<body>
<form action="/order" method="post">
  <label for="userinfoid">User id:
    <input type="text" name="userinfoid" id="userinfoid">
  </label><br>
  <label for="roomid">Room id:
    <input type="text" name="roomid" id="roomid">
  </label><br>
  <label for="beginTime">Begin Time:
    <input type="date" name="beginTime" id="beginTime">
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