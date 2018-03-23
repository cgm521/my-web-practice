/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.wx.servlet;

import com.wx.utils.oauthUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author cgm
 * @version $Id: login.java, v 0.1 2018-03-23 16:00 cgm Exp $$
 */
@WebServlet("/login")
public class login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        String backUrl = "公网地址"+"/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=" + oauthUtils.APP_ID
                + "&redirect_uri=" + URLEncoder.encode(backUrl,"UTF-8")
                + "&response_type=code"
                + "&scope=snsapi_base"
                + "&state=STATE#wechat_redirect";
//        String url1 = "https://www.baidu.com";
        resp.sendRedirect(url);
    }

}
