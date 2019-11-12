package com.example.frame.service;

import com.example.frame.domain.TbAdmin;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;

public class Test extends Service {
    public static void main(String[] args) {
        Conditions conditions = new Conditions(TbAdmin.class);
        /*TbAdmin admin=new TbAdmin();
        admin.setNumber("a");
       // String str= Md5Utils.md5Utils("a");
        admin.setPassword("str");*/
        conditions.putEW("number", "s");
        conditions.putEW("password", "s");




    }


}
