<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 15.03.2023
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateCompanyPost/${bute.id} " method="post" >
    <label > Company name </label>
    <input type="text" value="${bute.companyName}" name="companyName">
    <label> Located country </label>
    <input type="text" value="${bute.locatedCountry}" name="locatedCountry">
    <input type="submit" value="update">
</form>
</body>
</html>
