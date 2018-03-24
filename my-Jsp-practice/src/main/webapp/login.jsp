<%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/24
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div>
    <form name="login" action="do_login.jsp" method="post">
        <p class="main">
            <label>用户名:</label><label>
            <input type="text" name="username" value="">
        </label><br/>
            <label>密   码:</label><label>
            <input type="password" name="password" value="">
        </label><br/>
        </p>
        <p class="space">
            <input type="submit" value="登录"><br/>
        </p>
    </form>

</div>


</body>
</html>
