<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 14.03.2023
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/saveCourse1"method="post" >
    <label>courseName</label>
    <input type="text" name="courName">
    <label>duration</label>
    <input type="text" name="duration">
    <c:forEach items="${Course}" var="cor">
        <input type="radio" id="${cor.id}" name="id" value="${cor.id}">
        <label for="${cor.id}">${cor.companyName} </label>
    </c:forEach>
    <input type="submit" value="registrCours">
</form>
</body>
</html>
