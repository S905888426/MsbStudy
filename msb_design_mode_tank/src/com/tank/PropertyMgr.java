package com.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * Singleton 单例模式应用
 * auther:
 * Date:2020/9/1421:09
 **/
public class PropertyMgr {

    private PropertyMgr(){}

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if(props == null) return null;
        return props.get(key);
    }

}
