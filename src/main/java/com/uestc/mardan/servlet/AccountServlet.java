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

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uestc.mardan.domain.Account;
import com.uestc.mardan.query.AccountQuery;

public class AccountServlet extends HttpServlet {

    private AccountQuery AQ = new AccountQuery();

    /**
     * 获取
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");
        Account account = AQ.findById(Integer.parseInt(id));
        req.setAttribute("account", account);

        req.getRequestDispatcher("/WEB-INF/views/account/update.jsp").forward(req,resp);
        /*
         * List<Account> accounts = accountDao.findAll();
         *
         * req.setAttribute("accounts", accounts);
         *
         * req.getRequestDispatcher("/WEB-INF/views/account/list.jsp").forward(req,
         * resp);
         */
    }

    /**
     * 删除
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            int rows = AQ.delete(Integer.parseInt(id));

            resp.sendRedirect("/u/accounts");
        } catch (NumberFormatException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String accountId = req.getParameter("accountId");
        String email = req.getParameter("email");
        String nickName = req.getParameter("nickName");
        //nickName = new String( nickName.getBytes("iso-8859-1"), "utf-8" );
        try {
            Account account = new Account(email, null, nickName);
            account.setAccountId(Integer.parseInt(accountId));
            int rows = AQ.update(account);

            resp.sendRedirect("/u/accounts");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
