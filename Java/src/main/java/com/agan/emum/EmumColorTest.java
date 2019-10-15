package com.agan.emum;

import org.junit.Test;

/**
 * @author AganRun
 * @date 2019/10/15
 */
public class EmumColorTest {

    @Test
    public void testDemo(){
        System.out.println(Color.RED);
        System.out.println(Color.RED.getIndex() + ":" + Color.RED.getDesc());
    }
}
