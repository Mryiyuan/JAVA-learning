package com.qf.servlet3;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SafeServlet extends HttpServlet{
   // private String message="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //synchronized (this){//这个方法性能太低
        String message="";
            //假设1.接收参数
            //2调用业务逻辑 得到登陆结果
            message = "登录成功";
            PrintWriter printWriter = resp.getWriter();
            printWriter.println(message);

        //}

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
