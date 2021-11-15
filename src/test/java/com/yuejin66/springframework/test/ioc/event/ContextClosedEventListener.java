package com.yuejin66.springframework.test.ioc.event;

import main.java.com.yuejin66.springframework.context.ApplicationListener;
import main.java.com.yuejin66.springframework.context.event.ContextClosedEvent;

/**
 * @author lyj
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
