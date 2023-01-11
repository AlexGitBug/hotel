<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All my orders</title>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
_____________________________________________________________________________
<h1>All my orders</h1>
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
    <button type="submit">Download my orders</button>
</form>

_____________________________________________________________________________
<%@include file="footer.jsp" %>
</body>
</html>
<%--<ul>--%>
<%--    <a href="${pageContext.request.contextPath}/see_info_about_order?id=${userorderlist.id}">--%>
<%--        Order id: ${userorderlist.id}, User id: ${userorderlist.userInfo}, Room id: ${userorderlist.room},--%>
<%--        Begin time: ${userorderlist.beginTimeOfTheOrder}, End time: ${userorderlist.endTimeOfTheOrder},--%>
<%--        Condition: ${userorderlist.condition}, Message: ${userorderlist.message}--%>

<%--</ul>--%>
