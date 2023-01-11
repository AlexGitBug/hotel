<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Admin Page</title>
</head>

<body>
<%@ include file="header.jsp" %><br>
_____________________________________________________________________________<br>
<h1><fmt:message key="page.adminpage.Administration page"/></h1>

<form action="${pageContext.request.contextPath}/addroom" method="get">
    <button type="submit"><fmt:message key="page.adminpage.Addroom"/></button>
</form>
<form action="${pageContext.request.contextPath}/seeallordersforadmin" method="get">
    <button type="submit"><fmt:message key="page.adminpage.List of all orders for admin"/></button>
</form>
<form action="${pageContext.request.contextPath}/findallrooms" method="get">
    <button type="submit"><fmt:message key="page.adminpage.Display all rooms"/></button>
</form>
<form action="${pageContext.request.contextPath}/download_admin_report" method="get">
    <button type="submit"><fmt:message key="page.adminpage.Download all orders"/></button>
</form>
_____________________________________________________________________________<br>
<%@include file="footer.jsp" %>

</body>
</html>