<%@ page import="com.entity.user" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/24
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.entity.user" scope="page"/>
<jsp:useBean id="userDao" class="com.dao.userDao" scope="page"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>do_lgin</title>
</head>
<body>
<%
    user userByName = null;
    try {
        userByName = userDao.getUserByName(user.getName());
        out.println("user"+userByName.toString());
        System.out.println("user"+userByName.toString());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    //校验密码
    if (userByName != null && userByName.getPassword().equals(user.getPassword())) {
        session.setAttribute("user", user.getName());
        request.getRequestDispatcher("itemList_page.jsp").forward(request, response);
    } else {
        response.sendRedirect("login_fali.jsp");
    }

%>

</body>
</html>
