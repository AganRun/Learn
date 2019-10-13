package com.agan.fastjson;

import com.agan.fastjson.entity.Stu;
import org.junit.Test;
import com.alibaba.fastjson.JSON;

public class JsonDemo {

    @Test
    public void testToJson(){
        Stu stu = new Stu();
        stu.setAge(12).setName("wang");
        String jsonObject = JSON.toJSONString(stu);
        System.out.println(jsonObject);

        Stu stu2 = JSON.parseObject(jsonObject, Stu.class);
        System.out.println(stu2.toString());
    }

}
