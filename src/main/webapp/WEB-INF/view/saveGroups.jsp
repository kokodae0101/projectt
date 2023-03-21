<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 14.03.2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/saveGroup" method="post">
    <label>Group name</label>
    <input type="text" name="groupName">
    <label>Data Start</label>
    <input type="text" name="dataStart">
    <label>Data Finish</label>
    <input type="text" name="dataFinish">
    <h1>select Company </h1>
    <c:forEach items="${Company}" var="com">
        <input type="radio" id="${com.id}" name="idCom" value="${com.id}">
        <label for="${com.id}"> ${com.companyName} </label>
    </c:forEach>
    <h1>select Course </h1>
    <c:forEach items="${Course}" var="com">
        <input type="radio" id="${com.id}" name="idCor" value="${com.id}">
        <label for="${com.id}"> ${com.courName} </label>
    </c:forEach>
    <input type="submit" value="registrCourse">
</form>


</body>
</html>
