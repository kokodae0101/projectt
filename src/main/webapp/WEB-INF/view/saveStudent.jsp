<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 14.03.2023
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/saveStudent1" method="post">
    <label>First name</label>
    <input type="text" name="firstName">
    <label>last name</label>
    <input type="text" name="lastName">
    <label>email</label>
    <input type="text" name="email">
    <h1>select Group</h1>
    <c:forEach items="${Groups}" var="gr">
        <input type="radio" id="${gr.id}" name="IdGroup" value="${gr.id}">
        <label for="${gr.id}">${gr.groupName} </label>
    </c:forEach>
    <input type="submit" value="register ">
</form>
</body>
</html>
