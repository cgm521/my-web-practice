/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.service;

import com.entity.user;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author cgm
 * @version $Id: regServlet.java, v 0.1 2018-03-27 14:54 cgm Exp $$
 */
public class regServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getInitParameter("username"));
        System.out.println(config.getInitParameter("password"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user user = new user();
        //保存注册用户信息
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        req.getSession().setAttribute("user",req.getParameter("name"));
        System.out.println(req.getParameter("name"));

        out.println("大家好");
        //页面重定向
        resp.sendRedirect("itemList_page.jsp");
    }
}
