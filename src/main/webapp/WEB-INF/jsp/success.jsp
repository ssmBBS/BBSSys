<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25 0025
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Successfully job</p>
<!--传入了accounts-->
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.accountName}</td>
            <td>${account.email}</td>
            <td>${account.activadeCode}</td>
        </tr>
    </c:forEach>
</body>
</html>
