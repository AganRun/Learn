package Charpter03_operate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

class RandomUtil {
    Random random = new Random();

    public int getRandom(int x) {
        return random.nextInt(x);
    }

    public List<Integer> getRandoms(int x, int size) {
        List returns = new ArrayList();
        for (int i = 0; i < size; i++) {
            returns.add(random.nextInt(x));
        }
        return returns;
    }

}

public class C3_5_Random {

    public static void main(String[] args) {
        RandomUtil util = new RandomUtil();
        System.out.println(util.getRandom(10));
        Map<Integer, Long> collect = util.getRandoms(10, 100)
                .stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                        )
                );
        collect.forEach((k,v) -> System.out.println("number:" + k + ", count:" + v));
    }
}
