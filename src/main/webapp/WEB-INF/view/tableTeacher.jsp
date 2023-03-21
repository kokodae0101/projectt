<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 12.03.2023
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="2px">
    <th>firstName</th>
    <th>lastName</th>
    <th>email</th>
    <th>courseId</th>
    <th>delete</th>
    <c:forEach items="${teacher}" var="com">
        <tr>
            <td>${com.firstName}</td>
            <td>${com.lastName}</td>
            <td>${com.email}</td>
            <td>${com.course.id}</td>
            <td>
                <a href="/deleteTeacher/${com.id}"> delete </a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/Teacher">save</a>
<a href="/">back</a>
</body>
</html>
