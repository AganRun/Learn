package Charpter05_init_clean;

import java.util.Arrays;

public class C5_9Test {

    public static void main(String[] args) {
        Arrays.stream(C5_9Enum.values()).forEach( num -> {
            System.out.println(num.toString() + "," + num.getNum() + "->" + num.ordinal());
        });
    }
}
