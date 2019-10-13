package com.agan.javaeight.flatmap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {

    @Test
    public void demo(){
        String[] strings = new String[]{"Hello","World"};
        List<String[]> collect = Arrays.stream(strings).map(str -> str.split("")).distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<String> collect1 = Arrays.stream(strings)
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        collect1.forEach(System.out::print);

    }
}
