package com.uestc.mardan.maper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uestc.mardan.domain.Account;

public interface AccountMapper {

    //@Select("select * from account where account_id = #{id}")
    Account findById(int id);

    Account findByEmail(String email);

    List<Account> findAll(@Param("start") int start, @Param("offset") int offset);

    int insert(Account account);
}
