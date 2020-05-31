package Charpter12_collection;

public class Exercise15 {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        String str = "+U+n+c---+e+r+t---+a-+i+n+t+y---+-+r+u--+l+e+s---";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                stack.push(str.charAt(++i));
            } else if (str.charAt(i) == '-') {
                System.out.print(stack.pop());
            }
        }
        System.out.println("\n===================");
    }
}
