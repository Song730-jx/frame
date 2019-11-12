package com.example.frame.controller;


import com.example.frame.bean.FieldBean;
import com.example.frame.bean.PageBean;
import com.example.frame.bean.ResultBean;
import com.example.frame.domain.TbFraction;
import com.example.frame.domain.TbStudent;
import com.example.frame.service.QueryService;
import com.example.frame.service.StudentService;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.render.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;

@Controller
public class QueryController  extends BaseController {
    @Autowired
    private QueryService queryService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/doquery")
    public String query(){
        return "query";
    }

    @RequestMapping("/getListGrade")
    @ResponseBody
    public ResultBean query(FieldBean bean, PageBean pageBean){
        List<FieldBean> list=queryService.query(bean,pageBean);
        int count = queryService.count(bean);
        return success(list,count);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ServiceResult update(TbStudent student, TbFraction fraction){
        ServiceResult update=studentService.updateStudent(student,fraction);
        return update;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ServiceResult delete(TbStudent student){
        ServiceResult delete=studentService.deleteStudent(student);
        return delete;
    }

    @RequestMapping("/doExcel")
    @ResponseBody
    public Render doExcel(FieldBean bean, PageBean pageBean) {
        InputStream inputStream = queryService.excel(bean, pageBean);
        return Render.renderFile("学生信息表.xls", inputStream);
    }


}
