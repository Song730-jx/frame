package com.example.frame.domain;


import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
/**
 * 学生表
 */
public class TbStudent extends Domain {
    private Integer id;
    private String name; //学生姓名
    private Integer age; //年龄
    private Integer gradeid; //年级Id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }
}
