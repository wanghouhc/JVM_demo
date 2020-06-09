package com.huangchuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;




/**
 * 参数
 串行垃圾回收器 -XX:+UseSerialGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 并行垃圾回收器 -XX:+UseParNewGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 */
public class testGC {
    //不断产生新的对象，随机去销毁或者废弃对象
    public static void main(String[] args) throws Exception {
        List<Object>list=new ArrayList<Object>();
        while (true) {
            int sleep = new Random().nextInt(100);
            if (System.currentTimeMillis()%2==0){
                //当前时间是偶数，就废除当前对象
                list.clear();
            }else {
                //向list中添加对象
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key_"+i,"value_"+System.currentTimeMillis());
                    list.add(properties);
                }
            }

            Thread.sleep(sleep);
        }
    }
}
