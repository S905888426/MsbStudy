package com.study.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * auther:
 * Date:2020/7/921:00
 **/
@ConfigurationProperties(prefix = "person")
@Component
public class Person {

    private String name;
    private Integer age;
    private String sex;
    private List<String> likes;

    public Person() {
    }

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String lastName, Integer age, String sex, List<String> likes) {
        this.name = lastName;
        this.age = age;
        this.sex = sex;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setName(String lastName) {
        this.name = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", likes=" + likes +
                '}';
    }
}
