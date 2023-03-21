<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 12.03.2023
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>groupName</th>
    <th>dataStart</th>
    <th>dataFinish</th>
    <th>CompanyId</th>
    <th>Update</th>
    <th>delete</th>
    <c:forEach items="${group}" var="com">
        <tr>
            <td>${com.groupName}</td>
            <td>${com.dataStart}</td>
            <td>${com.dataFinish}</td>
            <td>${com.company.id}</td>
            <td>
                <form action="/updateGroups/${com.id}" method="get">
                    <button type="submit">
                        <a href="/updateGroups/${com.id}">
                            update
                        </a>
                    </button>
                </form>
            </td>
            <td>
                <a href="/deleteGroups/${com.id}"> delete </a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/groupsForm">save</a>
<a href="/">back</a>

</body>
</html>
