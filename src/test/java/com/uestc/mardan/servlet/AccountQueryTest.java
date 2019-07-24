/*
 ************ About ME ************
 * @author            : Mardan (ka1i)
 * @date              : Thu Jul 18 19:34:04 CST 2019
 * @e-mail            : GuzalInspire@hotmail.com
 *
 *********** About this ***********
 * @project           : helloservelet
 * @name              : servlet.java
 * @Last Modified by  : Mardan
 * @Last Modified time: Fri Jul 19 17:17:56 CST 2019
 */

package com.uestc.mardan.servlet;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import com.uestc.mardan.query.AccountQuery;
import com.uestc.mardan.domain.Account;

public class AccountQueryTest {
    private AccountQuery AQ = new AccountQuery();

    @Test
    public void testFindById() {
        Account account = AQ.findById(1102);
        System.out.println("\nfind by id 1102");
        System.out.println( account );
    }
    @Test
    public void testFindAll() {

        List<Account> accounts = AQ.findAll();
        System.out.println("\nFindALL");
        System.out.println( accounts );
        System.out.println("pprint:");
        for (Object objs : accounts) {
            System.out.print(objs+"\t");
            System.out.println();
        }
    }

    @Test
    public void testInsert() throws SQLException {
        Account account = new Account();
        account.setAccountId(1105);
        account.setEmail("11wangwu1@163.com");
        account.setPassword("12343456");
        account.setNickName("wangwu231");

        long accountId = AQ.insert(account);

        System.out.println( accountId );
    }
}
