package Charpter03_operate;

class Dog {
    String name;
    String says;
    Dog (String name, String says) {
        this.name = name;
        this.says = says;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return ((Dog)obj).name.equals(this.name) && ((Dog)obj).says.equals(this.says);
//    }
}

public class C3_7_2_EqualsDog {

    public static void main(String[] args) {
        Dog spot = new Dog("spot", "Ruff");
        Dog scruffy = new Dog("scruffy", "Wurf");
        System.out.println(spot.name + "-" + spot.says);

        System.out.println(scruffy == spot);

        scruffy = new Dog("spot", "Ruff");
        System.out.println(scruffy == spot);
//        System.out.println(scruffy.equals(spot));

        scruffy = spot;
        System.out.println(scruffy == spot);
    }
}
