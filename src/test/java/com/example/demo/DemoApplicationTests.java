package com.example.demo;

import com.example.demo.domain.ExcelData;
import com.example.demo.service.EmployeeService;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests{

    public Map<String,Object> map = new HashMap<String,Object>();

    public JSONObject jsonObject = new JSONObject();

    @Resource
    private EmployeeService employeeService;

    @Test
    public void contextLoads() {
        for(int i = 0; i < 10; i++) {
            int k = ++i;
            System.out.println(k);
        }

        String s = employeeService.queryCurrTime();
        System.out.println(s);

        String date = "2019-01-01 08:00:00";
        String query = employeeService.query(date);
        System.out.println(query);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void xml() throws Exception {
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.service.soapws.hss/\"><soapenv:Header><soapenv:Body><impl:importData><headers><batchNum>HLY201901150055UROETGtd</batchNum><sourceSystem>HELIOS</sourceSystem><statusCode>N</statusCode><header><sourceHeaderId>-1</sourceHeaderId><lineCount>607</lineCount><interfaceName>FSSC_HELIOS_REQUISITION</interfaceName><lines><line><value1>OBCN</value1><value2>O</value2><value3></value3></line><line><value1>123</value1><value2>B</value2></line></lines></header></headers></impl:importData></soapenv:Body></soapenv:Header></soapenv:Envelope>"
                ;
        //初始化报文，调用parse方法，获得结果map，然后按照需求取得字段，或者转化为其他格式
        JSONObject parse = new DemoApplicationTests().parse(xml);
        String value1 = parse.getString("value3");
        System.out.println(value1);
        System.out.println(parse);
        //获得字段s:SourceSysId的值;
//        String id = map.get("value1").toString();
//        System.out.println("value1=="+id);
    }

    public JSONObject parse(String soap) throws DocumentException{
        Document doc = DocumentHelper.parseText(soap);//报文转成doc对象
        Element root = doc.getRootElement();//获取根元素，准备递归解析这个XML树
        JSONObject code = getCode(root);
        return code;
    }

    public  JSONObject getCode(Element root){
        if(root.elements()!=null){
            List<Element> list = root.elements();//如果当前跟节点有子节点，找到子节点
            for(Element e:list){//遍历每个节点
                if(e.elements().size()>0){
                    getCode(e);//当前节点不为空的话，递归遍历子节点；
                }
                if(e.elements().size()==0){
                    map.put(e.getName(), e.getTextTrim());
                    jsonObject = JSONObject.fromObject(map);
                }//如果为叶子节点，那么直接把名字和值放入map
            }
        }
        return jsonObject;
    }

    public static String formatXml(Document document) throws Exception {
        OutputFormat format = OutputFormat.createPrettyPrint();
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }

    public static String formatXml(String xmlStr) throws Exception {
        Document document = DocumentHelper.parseText(xmlStr);
        return formatXml(document);
    }
}
