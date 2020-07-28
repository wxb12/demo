package com.example.demo.controllers;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;

@RestController
@RequestMapping("about")
public class TestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/count")
    public int count(HttpServletRequest request, HttpSession httpSession){
        try {
            Employee employee = new Employee();
            employee.setCompanyName("百度");
            String companyCode = "101";
            return employeeService.selectA(employee, companyCode);
        } catch (Exception e){
            return 200;
        }
    }
}
