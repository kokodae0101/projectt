<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 14.03.2023
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/saveTeacher" method="post">
    <label>first name</label>
    <input type="text" name="firstName">
    <label>lastName</label>
    <input type="text" name="lastName">
    <label>email</label>
    <input type="text" name="email">
    <h1>select Teacher</h1>
    <c:forEach items="${Teacher}" var="com">
        <input type="radio" id="${com.id}" name="IdCor" value="${com.id}">
        <label for="${com.id}" > ${com.courName} </label>
    </c:forEach>
    <input type="submit" value="register">
</form>
</body>
</html>