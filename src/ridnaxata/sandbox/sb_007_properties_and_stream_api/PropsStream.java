package ridnaxata.sandbox.sb_007_properties_and_stream_api;

import java.util.Properties;

public class PropsStream {

    public static void main(String[] args) {


        Properties props = new Properties();

        props.put("One", "1");
        props.put("Two", "2");
        props.put("Three", "3");
        props.put("Four", "4");

        // There are ANY stream API for old collection Properties in Java!!!!!!!!!
        ///props.stream();

    }

}
