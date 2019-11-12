package com.example.frame.controller;


import com.example.frame.domain.TbAdmin;
import com.example.frame.service.AdminService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/")
    public String admin(){
        return "land";
    }

    @RequestMapping("/land1")
    @ResponseBody
    public ServiceResult admin(TbAdmin a) {
        ServiceResult admin = adminService.query(a);
        return admin;
    }

    @RequestMapping("/doregister")
    public String register(){
        return "register";
    }

    @RequestMapping("/registerAdd")
    @ResponseBody
    public ServiceResult addAdmin(TbAdmin admin){
        ServiceResult admin1 = adminService.addAdmin(admin);
        return admin1;
    }

}
