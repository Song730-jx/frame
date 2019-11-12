package com.example.frame.domain;


import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;


/**
 * 分数表
 */
@Component
public class TbFraction extends Domain {
    private Integer id;
    private Integer studentId; //学生id
    private Integer fraction; //分数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }
}
