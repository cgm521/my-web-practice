<%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/23
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<%@ page import="static java.lang.System.out" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    String contextPath = request.getContextPath();
    String bassPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-size: 40px;text-align: center">


<a href="/login">微信授权登录</a>
<br><br><br>

<h1>out内置对象</h1>
<%
    out.println("静夜思");
    out.println("床前明月光");
    out.println("疑是地上霜");
    out.flush();
//    out.clear();
    out.clearBuffer();
    out.println("举头望明月");
    out.println("低头思故乡");
    SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
缓冲区大小：<%=out.getBufferSize()%>byte<br>
缓冲区剩余大小：<%=out.getRemaining()%>byte<br>
是否自动清空缓冲区：<%=out.isAutoFlush()%><br>

<%
    if (application.getAttribute("count") == null) {
        application.setAttribute("count", new Integer(0));
    }
    Integer count = (Integer) application.getAttribute("count");
    application
            .setAttribute("count", new Integer(count.intValue() + 1));
    count = (Integer) application.getAttribute("count");
%>
<center>
    这是第<%=count.intValue()%>个访问者!
</center>


</body>
</html>
