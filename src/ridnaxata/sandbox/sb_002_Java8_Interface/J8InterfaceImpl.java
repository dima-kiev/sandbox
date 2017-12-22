package ridnaxata.sandbox.sb_002_Java8_Interface;

public class J8InterfaceImpl implements J8Interface {

    @Override
    public void defaultMeth() {
        System.out.println("Impl default overriding");
    }

    public void superDefaultUse() {
        J8Interface.super.defaultMeth();
    }

    public void interfaceStaticUse() {
        J8Interface.staticMeth();
    }
}
