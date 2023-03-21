<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 16.03.2023
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateGroup/${ind.id}" method="post">
    <label> Group name</label>
    <input type="text" value="${ind.groupName}" name="groupName">
    <label> dataStart </label>
    <input type="text" value="${ind.dataStart}" name="dataStart">
    <label> dataFinish </label>
    <input type="text" value="${ind.dataFinish}" name="dataFinish">
    <input type="submit" value="update">
</form>
</body>
</html>

<%--<form action="/updateCourses/${ibu.id}" method="post">--%>
<%--    <label > Course name</label>--%>
<%--    <input type="text" value="${ibu.courName}" name="courName">--%>
<%--    <label> Duration </label>--%>
<%--    <input type="text" value="${ibu.duration}" name="duration">--%>
<%--    <input type="submit" value="update">--%>
<%--</form>--%>