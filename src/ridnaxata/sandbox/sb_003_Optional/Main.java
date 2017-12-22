package ridnaxata.sandbox.sb_003_Optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Map<String, Optional<Integer>> cases = new HashMap<>();

        cases.put("iEmpty", Optional.empty());
        cases.put("iOfNullableValue", Optional.ofNullable(111));
        cases.put("iOfNullableNull", Optional.ofNullable(null));
        cases.put("iOfValue", Optional.of(222));
        //cases.put("iOfNull", Optional.of(null)); // compile error because @NotNull at meth parameter
        //cases.put("", );

        cases.forEach((key, value) -> {
            System.out.println("===================");
            System.out.println(key);
            useCase01(value);
            System.out.println("===================");
        });
    }

    public static void useCase01(Optional<Integer> i) {

        //System.out.println(i.get()); // exeption on iOfNullableNull case

        i.ifPresent(System.out::println);

        Integer proved = i.orElse(0);
        System.out.println("prooved: " + proved);

        Integer proved1 = i.orElseGet(() -> 555);
        System.out.println("prooved: " + proved1);

        Integer proved2 = i.map(j -> j + 999).orElse(0);
        System.out.println("prooved: " + proved2);



    }

}
