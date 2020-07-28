package com.example.demo.domain;

/**
 * Created by WangXinbiao on 2019/01/25
 */
public class Demo {

    private String batchNum;
    private String sourceSystem;
    private String statusCode;
    private String sourceHeaderId;
    private String lineCount;
    private String interfaceName;
    private String value1;
    private String value2;

    @Override
    public String toString() {
        return "Demo{" +
                "batchNum='" + batchNum + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", sourceHeaderId='" + sourceHeaderId + '\'' +
                ", lineCount='" + lineCount + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSourceHeaderId() {
        return sourceHeaderId;
    }

    public void setSourceHeaderId(String sourceHeaderId) {
        this.sourceHeaderId = sourceHeaderId;
    }

    public String getLineCount() {
        return lineCount;
    }

    public void setLineCount(String lineCount) {
        this.lineCount = lineCount;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
