<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Регистрация</title>
</head>
<body>
<img width="252" height="252" src="${pageContext.request.contextPath}/images/users/test1.jpg" alt="User image">
<%--<img width="252" src="https://i.ytimg.com/vi/o5s5LLyQa6c/maxresdefault.jpg">--%>

<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
  <label for="name">First Name:
    <input type="text" name="name" id="name">
  </label><br>
  <label for="lastname">Last Name:
    <input type="text" name="lastname" id="lastname">
  </label><br>
  <label for="birthday">Birthday:
    <input type="date" name="birthday" id="birthday" required>
  </label><br>
  <label for="imageid">Image:
    <input type="file" name="image" id="imageid" required>
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
      <option value="${role.id}">${role.rank}</option>
    </c:forEach>
  </select><br>
  <button type="submit">Send</button>
</form>
</body>
</html>
