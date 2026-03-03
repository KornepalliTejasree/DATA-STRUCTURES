package OOPS;

public class interfaceChild implements interfaceA,interfaceB {
    int a=10;
    @Override
    public void acc() {
        System.out.println("interfaceChild accelerated");
    }

    @Override
    public void start() {
        System.out.println("interfaceChild started");
    }

    @Override
    public void brake() {
         System.out.println("interfaceChild braked");
    }

    @Override
    public void stop() {
        System.out.println("interfaceChild stopped");
    }
    
}
