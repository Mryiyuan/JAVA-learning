package com.qf.servlet2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/rs")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 1.获取用户请求发送到数据
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //System.out.println(username+","+password);

        //2 响应数据给客户端
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("register success!");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对request请求对象设置统一编码
        req.setCharacterEncoding("utf-8");
        // 1.获取用户请求发送到数据
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+","+password);

        //2 响应数据给客户端
//        resp.setCharacterEncoding("utf-8");
//        resp.setHeader("Content-Type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("注册成功!");
    }
}
