package com.qf.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/cs")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //1服务端创建Cookie对象
        Cookie cookie = new Cookie("username","lcc");
        Cookie cookie1 = new Cookie("password","123456");
        //1.1.设置Cookie的访问路径
        cookie.setPath("/webProject_war_exploded/get");
        cookie1.setPath("/webProject_war_exploded");
        //1.2设置cookie有效期
        cookie.setMaxAge(60*60);
        cookie1.setMaxAge(60*60);

        //2将Cookie响应给客户端
        resp.addCookie(cookie);
        resp.addCookie(cookie1);

    }
}
