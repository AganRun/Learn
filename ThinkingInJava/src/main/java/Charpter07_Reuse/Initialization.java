package Charpter07_Reuse;

class Parent{
    static int i = printInit("父类静态变量初始化");

    Parent(){
        System.out.println("父类构造方法");
    }

    protected static int printInit(String s) {
        System.out.println(s);
        return 47;
    }

    int y = printInit("父类非静态变量初始化");

    {
//        System.out.println("父类代码块");
    }
}

public class Initialization extends Parent{

    static int z = printInit("子类静态成员变量初始化");

    Initialization() {
        System.out.println("子类构造方法");
        System.out.println(y);
    }

    {

    }
    int y = printInit("子类非静态变量初始化");

    public static void main(String[] args) {
//        Initialization.printInit("父类调用");
        Initialization initialization = new Initialization();

    }
}
