package ridnaxata.sandbox.sb_006_reTry;

import java.util.Random;
import java.util.function.Consumer;

public class ReTryRun {


    public static void main(String[] args) {

        Consumer<Integer> consumer = (i) -> {
            int k = 5/0;
        };

        ReTry.reTry(3, 1, consumer);


    }

}
