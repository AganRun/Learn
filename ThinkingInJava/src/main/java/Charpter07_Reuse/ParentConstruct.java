package Charpter07_Reuse;

class a{
    a(){
        System.out.println("a");
    }
}

class b{
    b() {
        System.out.println("b");
    }
}

class c extends a {

}

public class ParentConstruct {

    public static void main(String[] args) {
        c c1 = new c();

    }
}
