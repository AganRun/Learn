package Charpter03_operate;

public class C3_10_BitOperation {

    public static void main(String[] args) {

        int a = 0xa;
        int b = 0x15;
        System.out.println("a = 0" + Integer.toBinaryString(a));
        System.out.println("b = " + Integer.toBinaryString(b));


        System.out.println("a&b " + (a&b) + "--" +  Integer.toBinaryString(a&b));
        System.out.println("a|b " + (a|b) + "--" +  Integer.toBinaryString(a|b));
        System.out.println("a^b " + (a^b) + "--" +  Integer.toBinaryString(a^b));
    }
}
