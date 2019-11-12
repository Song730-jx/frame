package com.example.frame.service;


import com.example.frame.bean.FieldBean;
import com.example.frame.bean.PageBean;
import com.example.frame.domain.TbStudent;
import net.atomarrow.bean.Pager;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class QueryService extends Service {
    /**
     * 模糊查询
     * @param bean
     * @return
     */
    public List<FieldBean> query(FieldBean bean, PageBean pageBean) {
        Conditions conditions = new Conditions(TbStudent.class);
        conditions.setReturnClass(FieldBean.class);
        conditions.setSelectValue("student.id,student.name,student.age,fraction.fraction,grade.grade ");
        conditions.setJoin(" student join tbfraction as fraction on student.id = fraction.studentid join tbgrade as grade on grade.id=student.gradeid");
        String name = null;
        String gradeId = null;
        System.out.println(bean.getGradeid());
        System.out.println(bean.getName());
        if (StringUtil.isNotBlank(bean.getName())) {
            name = bean.getName();
        } else {
            name = "";
        }
        conditions.putLIKE("name", name);

        if (bean.getGradeid() == 0) {
            gradeId = "%%";
        } else {
            gradeId = String.valueOf(bean.getGradeid());
        }
        conditions.putLIKE("gradeid", gradeId);
        conditions.putASC("fraction.studentId");

        Pager pager = new Pager();
        System.out.println(pageBean.getPage() + "当前页");
        System.out.println(pageBean.getLimit() + "当前数据");
        pager.setCurrentPage(pageBean.getPage());
        pager.setPageSize(pageBean.getLimit());

        List<FieldBean> list = getList(conditions);
        return list;
    }

    /**
     * 查询总数据条数
     * @return
     */
    public int count (FieldBean bean){
        Conditions conditions = new Conditions(TbStudent.class);
        int count = getCount(conditions);
        return count;
    }

    /**
     * 导出excel
     * @param bean
     * @param pageBean
     * @return
     */
    public InputStream excel(FieldBean bean, PageBean pageBean) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<FieldBean> list = query(bean,pageBean);
        excelDatas.addStringArray(0, 0, new String[]{"学号","姓名","学生年级", "成绩", "年龄"});
        excelDatas.addObjectList(1, 0, list, new String[]{"id","name", "grade", "fraction", "age"});//行,列,集合
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;

    }


}
