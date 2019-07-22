/*
 ************ About ME ************
 * @author            : Mardan (ka1i)
 * @date              : Thu Jul 18 10:00:24 CST 2019
 * @e-mail            : GuzalInspire@hotmail.com
 *
 *********** About this ***********
 * @project           : hello
 * @name              : JdbcUtils.java
 * @Last Modified by  : Mardan
 * @Last Modified time: Fri Jul 19 17:17:22 CST 2019
 */

package com.uestc.mardan.utils;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;
import java.sql.DriverManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
        dataSource.setUser("mardantest");
        dataSource.setPassword("88888888");
        dataSource.setJdbcUrl("jdbc:postgresql://192.168.160.133:5432/maven");
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
