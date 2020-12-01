package com.design.singleton;

/**
 * 完美单例 -- 枚举单例
 * 不仅可以解决线程同步，还可以防止序列化
 * auther: sunpan
 * Date:2020/9/14 22:35
 **/
public enum EnumSingle {
    INSTANCE;
}
