package task_b_01;

import java.util.Collection;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {

        return numbers
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        //Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3, 5, 7, 7, 7, 8, 9, 99, 11, 11);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}
