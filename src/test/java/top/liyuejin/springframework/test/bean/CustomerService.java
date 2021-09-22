package top.liyuejin.springframework.test.bean;

/**
 * @author lyj
 */
public class CustomerService {

    private String id;

    private CustomerDao customerDao;

    public void queryCustomerInfo() {
        customerDao.queryCustomerName(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
