package com.example.demo.domain;

import java.util.List;

/**
 * Created by WangXinbiao on 2019/01/04
 */
public class Page {
    private Employee employee;
    private String pageNo;
    private String pageSize;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
