package ridnaxata.sandbox.sb_002_Java8_Interface;

public interface J8Interface {

    void superDefaultUse();

    void interfaceStaticUse();

    default void defaultMeth() {
        System.out.println("Interface default");
    }

    static void staticMeth() {
        System.out.println("Interface static");
    }



}
