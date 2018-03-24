/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.wx.servlet;

import com.wx.utils.oauthUtils;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cgm
 * @version $Id: CallBackServlet.java, v 0.1 2018-03-23 16:18 cgm Exp $$
 */
@WebServlet("/callBack")
public class CallBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
                + "appid=" + oauthUtils.APP_ID
                + "&secret="+oauthUtils.APP_SECRET
                + "&code="+code
                + "&grant_type=authorization_code";
        //用code换取token
        String json = oauthUtils.doGetJson(url);
        JSONObject jsonObject = JSONObject.fromObject(json);
        String accessToken = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");

        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" +accessToken+
                "&openid=" +openid+
                "&lang=zh_CN";
        //拉取用户信息
        String info = oauthUtils.doGetJson(infoUrl);

        System.out.println(info);
        //
        req.setAttribute("info",info);
//         请求转发到登录成功页面
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
