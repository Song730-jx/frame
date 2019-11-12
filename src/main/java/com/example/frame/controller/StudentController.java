package com.example.frame.controller;

import com.example.frame.bean.ResultBean;
import com.example.frame.domain.TbStudent;
import com.example.frame.service.StudentService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/dostudentAdd")
    public String studentAdd(){
        return "studentAdd";
    }

    @RequestMapping("/studentAdd")
    @ResponseBody
    public ServiceResult addStudent(TbStudent student){
        ServiceResult student1 = studentService.addStudent(student);
        return student1;
    }

    @RequestMapping("/getListStudent")
    @ResponseBody
    public ResultBean getListStudent() {
        List<TbStudent> student = studentService.list();
        return success(student);
    }

}
