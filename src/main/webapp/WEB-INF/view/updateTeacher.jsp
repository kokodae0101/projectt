<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 16.03.2023
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateTeacher/${teac.id}" method="post">
    <label> firstName </label>
    <input type="text" value="${teac.firsName}" name="firstName">
    <label> lastName </label>
    <input type="text" value="${teac.lastName}" name="lastName">
    <label> email </label>
    <input type="text" value="${teac.email}" name="email">
    <input type= "submit" value="update">
</form>
</body>
</html>
