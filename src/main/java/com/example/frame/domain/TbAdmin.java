package com.example.frame.domain;


import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
/**
 * 管理员表
 */
public class TbAdmin extends Domain {
    private Integer id;
    private String number; //账号
    private String password; //密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
