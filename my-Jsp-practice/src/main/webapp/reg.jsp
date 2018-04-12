<%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/27
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div>
    <form name="login" action="/regServlet" method="post">
        <p class="main">
            <label>用户名:</label><label>
            <input type="text" name="name" value="">
        </label><br/>
            <label>密   码:</label><label>
            <input type="password" name="password" value="">
        </label><br/>
            <label>年   龄:</label><label>
            <input type="text" name="age" value="">
        </label><br/>
            <label>生   日:</label><label>
            <input type="date" name="birth" value="">
        </label><br/>
        </p>
        <p class="space">
            <input type="submit" value="注册"><br/>
        </p>
    </form>
</div>
</body>
</html>
