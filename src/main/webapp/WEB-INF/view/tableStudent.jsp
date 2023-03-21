<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>firstName</th>
    <th>lastName</th>
    <th>email</th>
    <th>update</th>
    <th>delete</th>
    <c:forEach items="${student}" var="com">
        <tr>
            <td>${com.firstName}</td>
            <td>${com.lastName}</td>
            <td>${com.email}</td>
            <td>
                <form action="/updateStudent/${com.id}" method="get">
                    <button type="submit">
                        <a href="/updateStudent/${com.id}">
                            update
                        </a>
                    </button>
                </form>
            </td>
            <td>
                <a href="/deleteStudent/${com.id}"> delete </a>
            </td>
        </tr>
    </c:forEach>

</table>
<a href="/saveStudent">save</a>
<a href="/">back</a>

</body>
</html>