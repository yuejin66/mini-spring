package com.yuejin66.springframework.test.bean.student;

/**
 * @author yuejin66
 */
public class StudentService {

    private String id;

    private String company;

    private String location;

    private StudentDao studentDao;

    public String queryStuInfo() {
        return studentDao.queryUserName(id) + "," + company + "," + location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
