package task_01;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rare {

    public static int nthMostRare(int[] elements, int n) {

        Optional<Map.Entry<Integer, Long>> searched = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(n)
                .skip(n - 1)
                .findFirst();

        Long res = (searched.orElseThrow(IllegalStateException::new)).getValue();

        return new BigDecimal(res).intValueExact();
    }

    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }

}
