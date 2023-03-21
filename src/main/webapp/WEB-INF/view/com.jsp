<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 17.03.2023
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
      <table>
  <td>
    <caption>Company</caption>
    <table border="2px">
      <th>company ID</th>
      <th>company name</th>
      <tr>
        <td>${co.id}</td>
        <td>${co.companyName}</td>
      </tr>
    </table>
  </td>
  <td>
    <h2>Course</h2>
    <table border="2px">
      <th>Course ID</th>
      <th>Course Name</th>
      <c:forEach items="${comi}" var="comi">
        <tr>
          <td>${comi.id}</td>
          <td>${comi.courName}</td>
        </tr>
      </c:forEach>
    </table>
  </td>
  <td>
    <h2>Groups</h2>
    <table border="2px">
      <th>Groups ID</th>
      <th>Groups Name</th>
      <c:forEach items="${com}" var="com">
        <tr>
          <td>${com.id}</td>
          <td>${com.groupName}</td>
        </tr>
      </c:forEach>
    </table>
  </td>
  <td>
    <h2>Teacher</h2>
    <table border="2px">
      <th>Teacher ID</th>
      <th>Teacher Name</th>
      <th>Course ID(Teacher)</th>
      <c:forEach items="${comina}" var="comina">
        <tr>
          <td>${comina.id}</td>
          <td>${comina.firstName}</td>
          <td>${comina.course.id}</td>
        </tr>
      </c:forEach>
    </table>
  </td>
  <td>
    <h2>Student</h2>
    <table border="2px">
      <th>Student ID</th>
      <th>Student Name</th>
      <th>Group ID(Student)</th>
      <c:forEach items="${comin}" var="comin">
        <tr>
          <td>${comin.id}</td>
          <td>${comin.firstName}</td>
          <td>${comin.group.id}</td>
        </tr>
      </c:forEach>
    </table>
  </td>
      </table>
</div>

</body>
</html>
