<%--
  Created by IntelliJ IDEA.
  User: кибер
  Date: 11.03.2023
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/saveCompany" method="post">
<label>companyName</label>
<input type="text" name="companyName">
    <label>companyCountry</label>
    <input type="text" name="locatedCountry">
    <input type="submit" value="registrCompany">
</form>
</body>
</html>
