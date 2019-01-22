package com.example.demo.controllers;

import com.example.demo.domain.DataTable;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Page;
import com.example.demo.service.EmployeeService;
import liquibase.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by WangXinbiao on 2018/12/13
 */

@RestController
@RequestMapping("public")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/list")
    public DataTable<Employee> findAll(HttpServletRequest request, HttpSession httpSession){

        DataTable<Employee> dataTable = new DataTable();
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String id = request.getParameter("businessCode");
        Page page = new Page();
        if (StringUtils.isNotEmpty(start)) {
            page.setPageNo(start);
            page.setPageSize(length);
        } else {
            page.setPageNo(String.valueOf(0));
            page.setPageSize("10");
        }
        Employee employee = new Employee();
        employee.setCompanyCode(id);
        page.setEmployee(employee);
        int i = employeeService.selectCount(employee);
        List<Employee> employees = employeeService.selectAll(page);
        dataTable.setData(employees);
        dataTable.setiTotalDisplayRecords(i);
        dataTable.setiTotalRecords(employees.size());

        System.out.println("123");

        System.out.println("haha");
        return dataTable;
    }

}
