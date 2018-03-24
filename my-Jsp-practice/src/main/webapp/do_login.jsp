<%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/24
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.po.user" scope="page"/>
<jsp:useBean id="userDao" class="com.po.userDao" scope="page"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>do_lgin</title>
</head>
<body>
<%
    if (userDao.doLogin(user)) {
        session.setAttribute("username",user.getUsername());
        request.getRequestDispatcher("welcome_page.jsp").forward(request,response);
    }else {
        response.sendRedirect("login_fali.jsp");
    }

%>

</body>
</html>
