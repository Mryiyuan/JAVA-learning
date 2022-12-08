package com.qf.servlet;

import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class GenServlet extends GenericServlet {
    @Override
    public void init() throws ServletException {
       System.out.println("genservlet init");
    }

    @Override
    //抽象类GenServlet 简化开发
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hehehe ");
    }
}
