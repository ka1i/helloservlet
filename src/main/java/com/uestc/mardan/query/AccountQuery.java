/*
 ************ About ME ************
 * @author            : Mardan (ka1i)
 * @date              : Thu Jul 18 10:00:24 CST 2019
 * @e-mail            : GuzalInspire@hotmail.com
 *
 *********** About this ***********
 * @project           : helloservlet
 * @name              : AccountQuery.java
 * @Last Modified by  : Mardan
 * @Last Modified time: Fri Jul 19 17:17:29 CST 2019
 */

package com.uestc.mardan.query;

import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

import com.uestc.mardan.maper.AccountMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import com.uestc.mardan.domain.Account;
import com.uestc.mardan.utils.JdbcUtils;

public class AccountQuery {

    private QueryRunner query = new QueryRunner(JdbcUtils.getDataSource());

    public Account findById(int id) {
        String sql = "SELECT ACCOUNT_ID ACCOUNTID, EMAIL, PASSWORD, NICK_NAME NICKNAME FROM ACCOUNT WHERE ACCOUNT_ID = ?";
        try {
            return query.query(sql, new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    public Account findByEmail(String email) {
        String sql = "SELECT ACCOUNT_ID ACCOUNTID, EMAIL, PASSWORD, NICK_NAME NICKNAME FROM ACCOUNT WHERE EMAIL = ?";
        try {
            return query.query(sql, new BeanHandler<Account>(Account.class), email);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public List<Account> findAll(){
        String sql = "SELECT ACCOUNT_ID ACCOUNTID, EMAIL, PASSWORD, NICK_NAME NICKNAME FROM ACCOUNT";

        try {
            return query.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

    public long insert( Account account ) throws SQLException {
        String sql = "INSERT INTO ACCOUNT(EMAIL, PASSWORD, NICK_NAME) VALUES(?,?,?)";

        try {
            return query.insert(sql, new ScalarHandler<Long>(1), account.getEmail(), account.getPassword(), account.getNickName());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
    }
    public int delete( int accountId ) throws SQLException {
        String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?";
        try {
            return query.execute(sql, accountId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
    }

    public int update( Account account ) throws SQLException {
        String sql = "UPDATE ACCOUNT SET EMAIL = ?, NICK_NAME = ? WHERE ACCOUNT_ID = ?";
        try {
            return query.update(sql, account.getEmail(), account.getNickName(), account.getAccountId());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
    }

    public void Show(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.160.132:5432/maven","mardan","2012weilai");
            String sql = "SELECT * FROM ACCOUNT";

            List<Object[]> result = query.query(conn,sql,new ArrayListHandler());
            for (Object[] objs : result) {
                for (Object obj : objs) {
                    System.out.print(obj+"\t");
                }
                System.out.println();
            }
            conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }
}
