package Charpter05_init_clean;

class A{
    String str;
}

class B{
    String str = new String("1");
}

class C{
    C(){
        str = new String("1");
    }
    String str;
}
public class C5_1Structure {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.str);

        B b = new B();
        System.out.println(b.str);

        C c = new C();
        System.out.println(c.str);

        System.out.println(b.str == c.str);
    }

}
