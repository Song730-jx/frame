package com.example.frame.service;

import com.example.frame.bean.FieldBean;
import com.example.frame.domain.TbFraction;
import com.example.frame.domain.TbStudent;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class FractionService extends Service {
    @Autowired
    private StudentService studentService;

    /**
     * 添加学生分数
     * @param fraction
     * @return
     */
    public ServiceResult addFraction(TbStudent student,TbFraction fraction){
        int id=studentService.getId(student.getName());
        fraction.setStudentId(id);
        add(fraction);
        return SUCCSS;
    }

    /**
     * 拿到学生的分数
     * @return
     */
    public List<TbFraction> listFraction(){
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.setReturnClass(FieldBean.class);
        conditions.setSelectValue("s.id,s.name,s.age,f.fraction,g.grade ");
        conditions.setJoin(" s join tbfraction as f on s.id = f.studentid join tbgrade as g on g.id=s.gradeid");
        List<TbFraction> list=getList(conditions);
        return list;
    }

    /**
     * 获取学生id，按studentId删除分数
     * @param id
     */
    public void deleteFraction(int id){
        Conditions conditions=new Conditions(TbFraction.class);
        conditions.putEW("studentId",id);
        delByBatch(conditions);
    }

    /**
     * 获取学生Id，按学生Id修改学生分数
     * @param id
     * @param fraction
     */
    public void updateFraction(int id,int fraction){
        Conditions conditions=new Conditions(TbFraction.class);
        conditions.putEW("studentId",id);
        modifyWithColumn(conditions, new Serializable[]{"fraction", fraction});
    }

}
