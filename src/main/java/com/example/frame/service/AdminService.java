package com.example.frame.service;


import com.example.frame.domain.TbAdmin;
import com.example.frame.util.Md5Utils;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;


@Component
public class AdminService extends Service {
    /**
     * 注册用户管理员
     * @param admin
     * @return
     */
    public ServiceResult addAdmin(TbAdmin admin) {
        String str = Md5Utils.md5Utils(admin.getPassword());
        admin.setPassword(str);
        add(admin);
        return success("注册成功");
    }

    /**
     * 判断用户是否存在，判断密码是否正确
     * @param admin
     * @return
     */
    public ServiceResult query(TbAdmin admin) {
        Conditions conditions = new Conditions(TbAdmin.class);
        String str = Md5Utils.md5Utils(admin.getPassword());
        conditions.putEW("number", admin.getNumber());
        conditions.putEW("password", str);
        int i = getCount(conditions);
        if (i == 0) {
            return error("该用户不存在");
        } else {
            if (str.equals(admin.getPassword())) {
                System.out.println("登录失败");
                return error("密码错误!");

            }
            System.out.println("登录成功");
            return success(admin);


        }
    }
}
