<%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<h2>欢迎<%= session.getAttribute("username") %> 登录成功</h2>
</body>
</html>
