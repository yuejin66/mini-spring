package com.yuejin66.springframework.test.event;

import main.java.com.yuejin66.springframework.context.ApplicationListener;
import main.java.com.yuejin66.springframework.context.event.ContextRefreshedEvent;

/**
 * @author lyj
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
