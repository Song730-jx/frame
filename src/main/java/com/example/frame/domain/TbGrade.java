package com.example.frame.domain;


import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
/**
 * 年级表
 */
public class TbGrade extends Domain {
    private Integer id;
    private String grade; //学生年级

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
