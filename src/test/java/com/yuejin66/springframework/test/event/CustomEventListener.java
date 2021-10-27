package com.yuejin66.springframework.test.event;

import main.java.com.yuejin66.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @author lyj
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息，时间：" + new Date());
        System.out.println("消息：" + event.getId() + "：" + event.getMessage());
    }
}
