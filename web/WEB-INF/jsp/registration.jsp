<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Регистрация</title>
</head>
<body>
<form action="/registration" method="post">
  <label for="name">First Name:
    <input type="text" name="name" id="name">
  </label><br>
  <label for="lastname">Last Name:
    <input type="text" name="lastname" id="lastname">
  </label><br>
  <label for="birthday">Birthday:
    <input type="date" name="birthday" id="birthday">
  </label><br>
  <label for="telephoneNumber">Telephone:
    <input type="text" name="telephoneNumber" id="telephoneNumber">
  </label><br>
  <label for="email">Email
    <input type="text" name="email" id="email">
  </label><br>Password:
  <label for="password">
    <input type="password" name="password" id="password">
  </label><br>Role:
  <select name="role" id="role">
    <c:forEach var="role" items="${requestScope.roles}">
      <option value="${role}">${role}</option>
    </c:forEach>
  </select><br>
  <button type="submit">Send</button>
</form>
</body>
</html>
