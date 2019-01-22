package com.example.demo.domain;

import lombok.Data;

/**
 * Created by WangXinbiao on 2018/12/27
 */
@Data
public class ExpenseReportToExcelDTO {

    //操作人+时间
    private String operator;
    //操作人
    private String fullName;
    //时间
    private String createdDate;
    //单号
    private String businessCode;
    //节点名称
    private String nodeName;
    //节点状态
    private String nodeStatus;
    //费用归属部门
    private String costAttributionDepartment;
    //归属部门编号
    private String departmentNumber;
    //事业部OU
    private String businessDivisionOU;
    // 节点耗时（分钟）
    private String nodeTimeMinutes;
    // 节点耗时（小时）
    private String nodeTimeHour;
    // 总条数
    private int total;
    // 总页数
    private int pages;

}
