package com.qf.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author LCC
 * \* @date: 2022/12/23
 * \* @time: 15:54
 * \* Description: Session Learning
 * \
 */
@WebServlet(name = "SessionServlet",value = "/ss")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过request1对象获取Session对象
        HttpSession session = req.getSession();
        System.out.println(session.getId());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}