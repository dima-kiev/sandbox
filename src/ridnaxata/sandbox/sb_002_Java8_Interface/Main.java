package ridnaxata.sandbox.sb_002_Java8_Interface;

public class Main {

    public static void main(String[] args) {

        J8Interface j8 = new J8InterfaceImpl();

        j8.defaultMeth();

        j8.superDefaultUse();

        J8Interface.staticMeth();

        j8.interfaceStaticUse();


    }

}
