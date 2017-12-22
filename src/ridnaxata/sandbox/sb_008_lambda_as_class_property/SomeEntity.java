package ridnaxata.sandbox.sb_008_lambda_as_class_property;

import java.util.Random;
import java.util.function.Predicate;

public class SomeEntity {

    private static int THRESHOLD = 25000;
    private static Random randomizer = new Random(100000);

    public static Predicate<SomeEntity> firstPredicate = (e) -> (THRESHOLD - e.getValue()) > 0;

    public Predicate<SomeEntity> fifthPredicate = (e) -> (THRESHOLD - e.getValue()) > 0;

    public Predicate<SomeEntity> thisPredicate = (e) -> (THRESHOLD - getValue()) > 0;

    private int value;

    public SomeEntity(int value) {
        this.value = randomizer.nextInt(THRESHOLD * value) + value;
    }

    public int getValue() {
        return value;
    }

    public static Predicate<SomeEntity> getFirstPredicate() {
        return firstPredicate;
    }

    public Predicate<SomeEntity> getSecondPredicate() {
        return (e) -> (THRESHOLD - e.getValue()) > 0;
    }

    // GOOD WAY TO BIND PREDICATE TO ENTITY

    public static Predicate<SomeEntity> getSixthPredicate() {
        return (e) -> (THRESHOLD - e.getValue()) > 0;
    }

    public Predicate<SomeEntity> getThisPredicate() {
        return thisPredicate;
    }
}
