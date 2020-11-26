package com.study.evolution.evolution2;


import com.study.evolution.evolution1.Student;

/**
 * @author: 马士兵教育
 * @create: 2019-10-13 16:40
 */
public class ScoreFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getScore()>75;
    }
}
