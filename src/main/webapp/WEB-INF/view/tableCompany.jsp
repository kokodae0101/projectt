<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 10.03.2023
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>Company ID:</th>
    <th>Company Name:</th>
    <th>Duration</th>
    <th>Update</th>
    <th> delete </th>
    <th> relation ship </th>

    <c:forEach items="${company}" var="com">
        <tr>
            <td>${com.id}</td>
            <td>${com.companyName}</td>
            <td>${com.locatedCountry}</td>
            <td>
                <form action="/updateCompany/${com.id}" method="get">
                    <button type="submit">
                        <a href="/updateCompany/${com.id}" >
                        update
                        </a>
                    </button>
                </form>
            </td>
            <td>
                <a href="/deleteCompany/${com.id}"> delete </a>
            </td>
            <td>
                <a href="/find/${com.id}">relation ship</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/companyForm">save</a>
<a href="/">back</a>
</body>
</html>
