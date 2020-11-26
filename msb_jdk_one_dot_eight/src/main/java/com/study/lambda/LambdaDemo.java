package com.study.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * auther:
 * remark: Lambda表达式练习
 * Date:2020/7/1322:04
 **/
public class LambdaDemo {

    public static void main(String[] args) {
        demoOne();
        demoTow();
    }

    /**
     * 创建线程
     */
    public static void demoOne(){

       //JDK1.8之前
       Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running.....");
            }
        });
        thread.start();

        //JDK1.8之后
       new Thread(()->{
           System.out.println("running2.....");
       }).start();

    }


    /**
     * 对数组进行排序
     */
    public static void demoTow(){

        //JDK1.8之前
        List<String> list = Arrays.asList("java","javascript","scala","python");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(String str:list){
            System.out.println(str);
        }

        //JDK1.8之前
        List<String> list2 = Arrays.asList("java","javascript","scala","python");
        Collections.sort(list2, (a,b) -> a.length() - b.length());
        list.forEach(System.out::println);

    }
}
