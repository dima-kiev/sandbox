package ridnaxata.sandbox.sb_009_collect_tomap_from_emptystream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmptyToMapStream {

    // CONCERN: Collectors.toMap on empty stream produses empty HashMap


    public static void main(String[] args) {


        Map<Integer, Integer> m = IntStream
                                    .range(100, 1000)
                                    .mapToObj(Integer::new)
                                    .filter(n -> n < 100)
                                    .collect(Collectors.toMap(k -> k, v -> v, (k1,k2) -> k1));

        System.out.println(m);


    }


}
