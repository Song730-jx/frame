package com.example.frame.controller;

import com.example.frame.bean.ResultBean;
import com.example.frame.domain.TbFraction;
import com.example.frame.domain.TbStudent;
import com.example.frame.service.FractionService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FractionController extends BaseController {
    @Autowired
    private FractionService fractionService;

    @RequestMapping("/dofractionAdd")
    public String fractionAdd(){
        return "fractionAdd";
    }

    @RequestMapping("/fraction")
    @ResponseBody
    public ServiceResult addFraction(TbStudent student,TbFraction fraction ){
        ServiceResult fraction1=fractionService.addFraction(student,fraction);
        return fraction1;
    }

    @RequestMapping("/getListFraction")
    @ResponseBody
    public ResultBean getListFraction() {
        List<TbFraction> student = fractionService.listFraction();
        return success(student);
    }

}
