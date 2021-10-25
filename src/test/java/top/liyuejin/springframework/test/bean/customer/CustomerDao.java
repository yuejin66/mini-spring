package top.liyuejin.springframework.test.bean.customer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyj
 */
public class CustomerDao {

    private static Map<String, String> map = new HashMap<>();

//    static {
//        map.put("10001", "客户A");
//        map.put("10002", "客户B");
//        map.put("10003", "客户C");
//    }

    public void initDataMethod() {
        System.out.println("执行：init-method");
        map.put("10001", "客户A");
        map.put("10002", "客户B");
        map.put("10003", "客户C");
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        map.clear();
    }

    public String queryCustomerName(String id) {
        return map.get(id);
    }
}
