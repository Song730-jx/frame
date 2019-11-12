package com.example.frame;

import com.example.frame.domain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.filter.ConfigScanner;
import net.atomarrow.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FrameApplicationTests extends Service {
    @Autowired
    private ConfigScanner configScanner;

    @Test
    void contextLoads() {
        Conditions conditions= new Conditions(TbStudent.class);
        List<TbStudent> students= getList(conditions);
        configScanner.scan();
        System.out.println(students);
    }

}
