package top.liyuejin.springframework.test.bean;

/**
 * @author lyj
 */
public class CustomerService {

    private String id;

    private String companyName;

    private String location;

    private CustomerDao customerDao;

    public String queryCustomerInfo() {
        return customerDao.queryCustomerName(id)
                .concat(",")
                .concat(companyName)
                .concat(",")
                .concat(location);
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
