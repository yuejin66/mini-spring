#### mini-spring

1. 创建简单的 Bean 容器
2. 实现 Bean 的定义、注册、获取
3. 对象实例化策略
4. 注入属性和依赖对象
5. 资源加载器解析文件注册对象（ClassPath、FileSystem 和 Url）
6. 应用上下文

#### 想到哪写到哪，最后再总结

1. 最核心的类是 DefaultListableBeanFactory，可以进行获取 Bean 的定义和 注册 Bean 的定义。
2. 对于抽象类的理解，就是对于 OOP 编程思想的理解，对于复杂业务的设计可以参考这里。
3. 对于设计模式的运用，还有 IOC、DI 和 AOP。
4. 对于加载静态资源的三种方式也很常用（以后可以复用），ClassPath、FileSystem 和 Url。