package com.agan.map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author AganRun
 * @date 2019/10/16
 */
@Getter
@Setter
@AllArgsConstructor
public class SelfKey {

    private String first;
    private String second;
    private String third;

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode() + third.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
//        super.equals(obj);
        SelfKey selfKey = (SelfKey) obj;
        boolean equals1 = Objects.equals(this.first, selfKey.getFirst());
        boolean equals2 = Objects.equals(this.second, selfKey.getSecond());
        boolean equals3 = Objects.equals(this.third, selfKey.getThird());
        return equals1 && equals2 && equals3;
    }
}
