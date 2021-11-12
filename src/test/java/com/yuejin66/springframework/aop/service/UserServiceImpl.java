package com.yuejin66.springframework.aop.service;

import java.util.Random;

/**
 * @author lyj
 */
public class UserServiceImpl implements UserService{

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "lee, 10001, 广州";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + "success！";
    }
}
