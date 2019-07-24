package com.uestc.mardan.service;

import com.uestc.mardan.domain.Account;
import com.uestc.mardan.utils.JdbcUtils;
import org.apache.ibatis.session.SqlSession;

public class AccountService {
    public Account login(String email,String password){
        try{
            JdbcUtils.begin();
            SqlSession session = JdbcUtils.getSession();
            session.selectOne("",email);
            JdbcUtils.commit();
        }catch (Exception e){
            JdbcUtils.rollback();
        }

    }
}
