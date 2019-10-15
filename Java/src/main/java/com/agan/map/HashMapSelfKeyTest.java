package com.agan.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AganRun
 * @date 2019/10/16
 */
@Slf4j
public class HashMapSelfKeyTest {

    @Test
    public void test(){
        SelfKey selfKey1 = new SelfKey("1","2","3");
        SelfKey selfKey2 = new SelfKey("3","2","1");

        Map<SelfKey, String> map = new HashMap<>();
        map.put(selfKey1, "value1");
        map.put(selfKey2, "value2");

        /**
         * 如果不重写hashcode和equals方法，至于put时的对象可以取出对应的值
         * 第一个输出：06:53:50.193 [main] INFO com.agan.map.HashMapSelfKeyTest - null
         * 第二个输出：06:53:50.195 [main] INFO com.agan.map.HashMapSelfKeyTest - value1
         *
         * 如果只重写hashCode方法。equals比较时依旧比较内存地址，导致不通过
         * 输出结果和第一个相同
         *
         * 自定义重写了hashCode和Equeals方法后
         * 07:02:47.469 [main] INFO com.agan.map.HashMapSelfKeyTest - value1
         * 07:02:47.472 [main] INFO com.agan.map.HashMapSelfKeyTest - value1
         */
        log.info(map.get(new SelfKey("1", "2", "3")));
        log.info(map.get(selfKey1));
    }


}
