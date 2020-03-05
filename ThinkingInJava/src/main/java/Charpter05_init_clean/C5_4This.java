package Charpter05_init_clean;

public class C5_4This {

    public static void main(String[] args) {
        C5_4This c = new C5_4This();
        c.f1();
    }
    void f1(){
        f2();
        this.f2();
    }

    void f2() {
        System.out.println("-----");
    }
}
