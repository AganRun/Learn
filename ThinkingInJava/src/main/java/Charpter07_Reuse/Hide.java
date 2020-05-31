package Charpter07_Reuse;

class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return c;
    }
    float doh(float c) {
        System.out.println("doh(float)");
        return c;
    }
}

class Milhouse {

}

class Bart extends Homer{
    Milhouse doh(Milhouse c) {
        System.out.println("doh(milhouse)");
        return c;
    }

    @Override
    float doh(float c) {
        System.out.println("bart float");
        return c;
    }
}

public class Hide {

    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('1');
        b.doh(1f);
        b.doh(new Milhouse());
    }
}
