package com.agan.emum;

import lombok.Getter;
import lombok.Setter;

/**
 * @author AganRun
 * @date 2019/10/15
 */
@Getter
public enum Color {

    //颜色
    RED(1, "红色"),
    GREEN(2, "绿色"),
    YELLOW(3, "黄色");

    private Integer index;
    private String desc;

    private Color(Integer index, String desc){
        this.index = index;
        this.desc = desc;
    }

}
