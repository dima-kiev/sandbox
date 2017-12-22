package ridnaxata.sandbox.sb_006_reTry;

import java.util.function.Consumer;
import java.util.function.Function;

public class ReTry {

    public static <T extends Exception, P> void reTry(int tries, P parameter, Consumer<P> consumer) throws T {

        Exception occuredLastTime = null;

        for (int i = 0; i < tries; i++) {
            try {
                System.out.println(" try # " + (i + 1));
                occuredLastTime = null;
                consumer.accept(parameter);
            } catch (Exception e) {
                occuredLastTime = e;
            }
        }

        if (occuredLastTime != null) {
            throw (T) occuredLastTime;
        } else {
            return;
        }

    }

}
