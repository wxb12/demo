package com.example.demo.service;

import com.example.demo.controllers.MyWebSocket;
import com.example.demo.domain.Task;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by WangXinbiao on 2019/02/28
 */
@Service
public class AutoTaskExecutor {
    private static final Logger log = LoggerFactory.getLogger(AutoTaskExecutor.class);

    @Autowired
    private MyWebSocket myWebSocket;

//    @Scheduled(
//        cron = "0/30 * * * * *"
//    )
//    public void ssss(){
//        Date date = new Date();
//        System.out.println(date + "s");
//        try {
//            Thread.sleep(5000);
//            System.out.println(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Scheduled(
//            cron = "0/30 * * * * *"
//    )
//    public void aaa(){
//        Date date = new Date();
//        System.out.println(date + "a");
//        try {
//            Thread.sleep(5000);
//            System.out.println(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Scheduled(
        cron = "0/30 * * * * *"
    )
    public void webSocket(){
        try {
            for (int i =0 ; i<5 ; i++){
                    myWebSocket.sendMessage(String.valueOf(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    @Scheduled(
//            cron = "0/30 * * * * *"
//    )
//    public void start() {
//        System.out.println("定时任务开始了");
//        Date now = new Date();
//        Task midTask1 = new Task();
//        midTask1.setStartTime(now);
//        midTask1.setIsActive(true);
//        midTask1.setCompanyid(this.midConfigurationService.findConfigurationValueByItem("token.companyid"));
//        Date endDate = DateUtils.addSeconds(now, -10);
//        List<Task> list = this.midTaskService.queryMidTask(midTask1);
//
//        for(int i = 0; i < list.size(); ++i) {
//            Task midTask = (Task)list.get(i);
//            MidRequestContext midRequestContext = new MidRequestContext();
//            midRequestContext.setTaskId(midTask.getId());
//            midRequestContext.setCronName("CronTask");
//            MidRequestContextHelper.setCurrentRequest(midRequestContext);
//            String start = null;
//            String end = null;
//
//            try {
//                log.info("取得待导入数据{}条,正在处理第{}条数据...", list.size(), i + 1);
//                String beanName = midTask.getBeanName();
//                Object obj = SpringUtil.getBean(beanName);
//                Class clazz = obj.getClass();
//                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//                start = sdf.format(midTask.getLastTime());
//                end = sdf.format(endDate);
//                Method method = clazz.getDeclaredMethod(midTask.getMethod(), String.class, String.class);
//                method.setAccessible(true);
//                method.invoke(obj, start, end);
//                Date date = CronUtil.getNextTime(now, midTask.getRule());
//                midTask.setLastTime(endDate);
//                midTask.setStartTime(date);
//                this.midTaskService.update(midTask);
//            } catch (Exception var19) {
//                log.error("抓取数据出错,开始时间:{},结束时间:{},错误信息为:{}", new Object[]{start, end, var19.getMessage()});
//                Date date = CronUtil.getNextTime(now, midTask.getRule());
//                midTask.setLastTime(endDate);
//                midTask.setStartTime(date);
//                this.midTaskService.update(midTask);
//            } finally {
//                ;
//            }
//        }
//
//    }

}

