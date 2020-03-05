package Charpter04_control_execution;

/**
 *  吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到。而这对数字各包含乘积的一半位数的数字。
 *  其中从最初的数字选取的数字可以任意排序。从两个0结尾的数字是不允许的。例如，下列数字都是吸血鬼数字
 *  1260 = 21 * 60
 *  1827 = 21 * 87
 *  2187 = 27 * 81
 */
public class C4_8_Vampirefigures {

    public static void main(String[] args) {
        System.out.println(isVampireFigures(1200));
    }

    public static boolean isVampireFigures(int number) {
        String str = String.valueOf(number);
        if (str.length()%2 != 0 || str.endsWith("00")) {
            return false;
        }
        int size = str.length();
        
        return true;
    }
}
