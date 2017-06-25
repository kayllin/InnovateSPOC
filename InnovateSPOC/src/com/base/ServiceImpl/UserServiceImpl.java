package com.base.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.base.Service.UserService;
import com.base.Dao.UserDao;


@Service("UserService")
public class UserServiceImpl implements UserService {

    
    @Autowired
    private UserDao userdao;
    @Override
    public boolean login(String username, String password) {
	// TODO Auto-generated method stub
	return userdao.login(username, password);
    }

}
