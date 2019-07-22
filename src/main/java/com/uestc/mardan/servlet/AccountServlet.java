/*
 ************ About ME ************
 * @author            : Mardan (ka1i)
 * @date              : Thu Jul 18 10:00:24 CST 2019
 * @e-mail            : GuzalInspire@hotmail.com
 *
 *********** About this ***********
 * @project           : helloservlet
 * @name              : AccountServlet.java
 * @Last Modified by  : Mardan
 * @Last Modified time: Fri Jul 19 17:17:22 CST 2019
 */

package com.uestc.mardan.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AccountServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {

        message = "Hello World Java Servlet class";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");


        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy()
    {

    }
}
