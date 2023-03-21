<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 12.03.2023
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>Course ID:</th>
    <th>Course Name:</th>
    <th>Duration</th>
    <th>CompanyId</th>
    <th>update</th>
    <th> delete </th>
    <c:forEach items="${course}" var="com">
        <tr>
            <td>${com.id}</td>
            <td>${com.courName}</td>
            <td>${com.duration}</td>
            <td>${com.company.id}</td>
            <td>
                <form action="/updateCourse/${com.id}" method="get">
                    <button type="submit">
                        <a href="/updateCourse/${com.id}">
                            update
                        </a>
                    </button>
                </form>
            </td>
       <td>
           <a href="/deleteCourse/${com.id}"> delete </a>
       </td>
        </tr>
    </c:forEach>
</table>
<a href="/saveCourse">save</a>
<a href="/">back</a>

</body>
</html>
