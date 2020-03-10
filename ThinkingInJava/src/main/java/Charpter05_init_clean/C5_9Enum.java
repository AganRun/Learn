package Charpter05_init_clean;

public enum C5_9Enum {

    ONE(1), TWO(2), THIRD(3);

    int num;

    C5_9Enum(int a) {
        num = a;
    }

    public int getNum() {
        return num;
    }
}
