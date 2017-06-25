package com.base.Dao;

public interface UserDao {
    /**
     * 用户名username 密码：password
     * 
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password);
}
