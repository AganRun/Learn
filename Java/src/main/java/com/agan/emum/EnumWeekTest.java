package com.agan.emum;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author AganRun
 * @date 2019/10/15
 */
public class EnumWeekTest {

    /**
     * 该方法用于与制定枚举对象比较顺序，
     * 同一个枚举实例只能与相同类型的枚举实例比较。
     * 如果该枚举对象位于指定枚举对象之后，则返回正整数；反之返回负整数；否则返回零；
     */
    @Test
    public void testCompare(){
        //-4
        System.out.println(WeekEnum.MONDAY.compareTo(WeekEnum.FRIDAY));
    }

    @Test
    public void testNameValue(){
        //MONDAY
        System.out.println(WeekEnum.MONDAY.name());
        //SUNDAY...SATURDAY,重写了ToString后变成星期日...星期六
     Arrays.asList(WeekEnum.values()).forEach(System.out::println);
    }

    @Test
    public void testToString(){
        //星期日...星期六
        for (WeekEnum we : WeekEnum.values()) {
            System.out.println(we);
        }
    }

    @Test
    public void testCreate(){
        WeekEnum weekEnum = WeekEnum.MONDAY;
        System.out.println(weekEnum.getDate());
    }

    /**
     * 索引，根据定义时先后顺序，从0开始
     */
    @Test
    public void testOrdinal(){
        System.out.println(WeekEnum.MONDAY.ordinal());
        //0
        System.out.println(WeekEnum.SUNDAY.ordinal());
    }

    @Test
    public void testVauleOf(){
        //报错
//        System.out.println(WeekEnum.valueOf("星期一"));

        //星期一(因为重写了toString)
        System.out.println(WeekEnum.valueOf("MONDAY"));
        //星期一
        System.out.println(WeekEnum.valueOf(WeekEnum.class, "MONDAY"));
    }

}
