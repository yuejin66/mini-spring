package top.liyuejin.springframework.test.bean.customer;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.*;
import main.java.top.liyuejin.springframework.context.ApplicationContext;
import main.java.top.liyuejin.springframework.context.ApplicationContextAware;
import top.liyuejin.springframework.test.bean.customer.CustomerDao;

/**
 * @author lyj
 */
public class CustomerService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware,
        BeanFactoryAware, InitializingBean, DisposableBean {

    private String id;

    private String companyName;

    private String location;

    private CustomerDao customerDao;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    public String queryCustomerInfo() {
        return customerDao.queryCustomerName(id);
    }

    public String getCustomer() {
        String info = customerDao.queryCustomerName(id);
        return info + "," + companyName + "," + location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("Bean Name is: " + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /* getter,setter */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
