/*
 ************ About ME ************
 * @author            : Mardan (ka1i)
 * @date              : Thu Jul 18 10:00:24 CST 2019
 * @e-mail            : GuzalInspire@hotmail.com
 *
 *********** About this ***********
 * @project           : hello
 * @name              : Account.java
 * @Last Modified by  : Mardan
 * @Last Modified time: Fri Jul 19 17:17:33 CST 2019
 */

package com.uestc.mardan.domain;

public class Account {

    private Integer accountId;
    private String email;
    private String password;
    private String nickName;

    public Account() {}
    public Account(String email, String password, String nickName) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public Integer getAccountId() {
        return accountId;
    }
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", email=" + email + ", password=" + password + ", nickName="
                + nickName + "]";
    }
}
