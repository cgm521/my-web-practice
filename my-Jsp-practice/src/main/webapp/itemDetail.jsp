<%@ page import="com.dao.itemDao" %>
<%@ page import="com.entity.item" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: cgm
  Date: 2018/3/26
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
</head>
<%
    itemDao itemDao = new itemDao();
    item item = null;
    String ids = null;
    Cookie[] cookies;
    try {
        item = itemDao.findItemById(Integer.parseInt(request.getParameter("id")));
        //获取当前用户的session缓存
        cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (session.getAttribute("user").toString().equals(c.getName())) {
                ids = c.getValue();
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<body>
<h2>商品详情</h2>
<br>
<br>
<br>
<div>
    <div><img src="image/<%= item.getImg() %>.jpeg" height="200" width="200"></div>
    <br>
    <div>产自：<%= item.getSource()%>
    </div>
    <div>价格：<%= item.getPrice()%>
    </div>

</div>

<br>
<hr style=" height:2px;border:none;border-top:2px dotted #185598;"/>

<h3>浏览过的</h3>
<div>
        <%
            if (ids!=null){
                String[] split = ids.split(",");
            for (int i=0;i<3 && i<split.length-1;i++) {
                item itemById = itemDao.findItemById(Integer.parseInt(split[i]));
        %>
    <div>
        <div><img src="image/<%= itemById.getImg() %>.jpeg" height="200" width="200"></div>
        <br>
        <div>产自：<%= itemById.getSource()%>
        </div>
        <div>价格：<%= itemById.getPrice()%>
        </div>

        <%
                }

                String newIds = null;
                if (split.length > 1000) {
                    for (int i = 0; i < 5; i++) {
                        newIds += split[i] + ",";
                    }
                    ids = newIds.substring(0, newIds.lastIndexOf(","));
                }
            }
            if (ids == null || ids == "") {
                ids = item.getId() + "";
            } else {
                ids = item.getId() + "," + ids;
            }

            Cookie user = new Cookie(session.getAttribute("user").toString(), ids);
            response.addCookie(user);
        %>
    </div>
</body>
</html>
