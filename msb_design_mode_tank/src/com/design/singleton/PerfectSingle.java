package com.design.singleton;

/**
 * 完美单例 -- 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * auther: sunpan
 * Date:2020/9/1422:31
 **/
public class PerfectSingle {

    private PerfectSingle(){}

    private static class PerfectSingleHolder{
        private final static PerfectSingle INSTANCE = new PerfectSingle();
    }

    public static PerfectSingle getInstance(){
        return PerfectSingleHolder.INSTANCE;
    }

}
