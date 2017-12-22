package ridnaxata.sandbox.sb_008_lambda_as_class_property;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FilterUsage {

    private static Predicate<SomeEntity> thirdPredicate = (e) -> (25000 - e.getValue()) > 0;

    public static void main(String[] args) {

        Predicate<SomeEntity> secondPredicate = (e) -> (25000 - e.getValue()) > 0;

        long res = IntStream
                .range(1, 1000)
                .mapToObj(SomeEntity::new)
                .filter(secondPredicate)
                .filter(thirdPredicate)

                // The same but not works
                .filter(getThirdPredicate())
                //.filter(FilterUsage::getThirdPredicate)

                .filter(getXZPredicate())

                // GOOD WAY TO BIND PREDICATE TO ENTITY
                .filter(SomeEntity.getSixthPredicate())

                .filter(SomeEntity.getFirstPredicate())
                .filter(SomeEntity.firstPredicate)

                // NOT WORKS
//                .filter(SomeEntity.getThisPredicate())
//                .filter(SomeEntity::getThisPredicate)
//                .filter(SomeEntity::getFirstPredicate)
//                .filter(SomeEntity::getSecondPredicate)

                .map(SomeEntity::getValue)
                .count();

        System.out.println(res);


    }

    public static Predicate<SomeEntity> getThirdPredicate() {
        return thirdPredicate;
    }

    public static Predicate<SomeEntity> getXZPredicate() {
        return SomeEntity.getFirstPredicate();
    }
}
