package com.yuejin66.springframework.test.ioc.bean.user;

/**
 * @author lyj
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        return name;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
