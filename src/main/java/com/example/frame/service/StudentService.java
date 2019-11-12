package com.example.frame.service;


import com.example.frame.domain.TbFraction;
import com.example.frame.domain.TbStudent;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService extends Service {
    @Autowired
    private FractionService fractionService;

    /**
     * 添加学生
     * @param student
     * @return
     */
    public ServiceResult addStudent(TbStudent student) {
        add(student);
        return SUCCSS;
    }

    /**
     * 获取学生表信息
     * @return
     */
    public List<TbStudent> list() {
        Conditions conditions = new Conditions(TbStudent.class);
        List<TbStudent> students = getList(conditions);
        return students;
    }

    /**
     * 修改学生信息
     * @param student
     * @param fraction
     * @return
     */
    public ServiceResult updateStudent(TbStudent student, TbFraction fraction){
        fractionService.updateFraction(student.getId(),fraction.getFraction());
        modify(student);
        return SUCCSS;
    }

    /**
     * 删除学生
     * @param student
     * @return
     */
    public ServiceResult deleteStudent(TbStudent student){
        del(student);
        fractionService.deleteFraction(student.getId());
        return success(student);
    }

    /**
     * 按学生姓名查找学生Id，返回Id
     * @param name
     * @return
     */
    public int getId(String name){
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.putEW("name",name);
        TbStudent get=getOne(conditions);
        int id=get.getId();
        return id;
    }

}
