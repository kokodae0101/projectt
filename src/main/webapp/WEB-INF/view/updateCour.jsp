<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 15.03.2023
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateCourses/${ibu.id}" method="post">
    <label > Course name</label>
    <input type="text" value="${ibu.courName}" name="courName">
    <label> Duration </label>
    <input type="text" value="${ibu.duration}" name="duration">
    <input type="submit" value="update">
</form>
</body>
</html>


