<%@ page import="com.dao.itemDao" %>
<%@ page import="com.entity.item" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/26
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>商品展示</title>
</head>
<body>
<%
    itemDao itemDao = new itemDao();
    List<item> listItem = null;
    try {
        listItem = itemDao.findListItem();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    for (item item : listItem) {
%>
<h2>商品展示</h2>
<br/>
<br/>
<br/>
<div>
    <a href="itemDetail.jsp?id=<%= item.getId() %>">
        <div><img src="image/<%= item.getImg() %>.jpeg" height="200" width="200"></div>
        <br>
        <div>产自：<%= item.getSource()%>
        </div>
        <div>价格：<%= item.getPrice()%>
        </div>
    </a>
</div>


<%
    }
%>
</body>
</html>
