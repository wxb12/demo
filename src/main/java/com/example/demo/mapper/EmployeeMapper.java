package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Page;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> selectAll(Page page);

    int selectCount(Employee employee);

}
