package com.jzl.serviceImpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.jzl.dao.user.UserDao;
import com.jzl.service.user.UserService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-12
 * 
 */
@Service(value = "userService")
public class UserServiceImpl extends MybatisBaseServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public MyBatisBaseDao getDao() {
        return userDao;
    }

}
