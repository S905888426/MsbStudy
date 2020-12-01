package com.study;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class SpringbootStudyApplicationTests {

    @Autowired
    Person person;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoadOne() {
        System.out.println(person);
    }

    @Test
    void contextLoads() throws Exception{
        System.out.println(dataSource.getClass());
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("initSize:"+druidDataSource.getInitialSize());
        System.out.println("maxSize:"+druidDataSource.getMaxActive());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
