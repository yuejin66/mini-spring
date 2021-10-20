package top.liyuejin.springframework.test.bean;

import main.java.top.liyuejin.springframework.beans.factory.DisposableBean;
import main.java.top.liyuejin.springframework.beans.factory.InitializingBean;

/**
 * @author lyj
 */
public class CustomerService implements InitializingBean, DisposableBean {

    private String id;

    private String companyName;

    private String location;

    private CustomerDao customerDao;

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
}
