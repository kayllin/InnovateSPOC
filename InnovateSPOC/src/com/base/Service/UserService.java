package com.base.Service;

public interface UserService {
    /**
     * 用户名username 密码：password
     * 
     * @param username
     * @param password
     * @return
     */
    public boolean login(String usename, String password);
}
