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
import java.io.IOException;
import java.io.Reader;
import java.sql.DriverManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdk.internal.loader.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

    public  static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<T>;

    static {
        String resoure = "mybatis-config.xml";
        Reader inputStream;
        try {
            inputStream = Resources.getResourceAsReader(resoure);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static SqlSession getSession(){
        SqlSession session = tl.get();
        if (session == null){
            session = sqlSessionFactory.openSession(true);
            tl.set(session);
        }
        return  session;
    }

    public static void begin(){
        SqlSession session = sqlSessionFactory.openSession();
        tl.set(session);
    }

    public static void commit(){
        SqlSession session = tl.get();
        if(session != null){
            session.commit();
            session.close();
            tl.remove();
        }
    }

    public static void rollback(){
        SqlSession session = tl.get();
        if (session != null){
            session.rollback();
            session.close();
            tl.remove();
        }
    }

    public static void close(){
        SqlSession session = tl.get();
        if (session != null){
            session.close();
            tl.remove();
        }
    }

}
