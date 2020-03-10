package Charpter05_init_clean;

public class C5_7Construct {

    private int i;
    {
        System.out.println(i);
    }

    public C5_7Construct(){
        i = 7;
    }

    public static void main(String[] args) {
        C5_7Construct test = new C5_7Construct();
        System.out.println(test.i);
    }
}
