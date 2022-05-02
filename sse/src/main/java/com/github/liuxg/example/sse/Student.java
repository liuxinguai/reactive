package com.github.liuxg.example.sse;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinguai.liu
 */
@Data
public class Student implements Serializable {

    /**
     * 学号
     */
    private Integer stuNo;

    /**
     * 姓名
     */
    private String stuName;
}
