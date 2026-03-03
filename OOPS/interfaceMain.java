package OOPS;

public class interfaceMain {
    public static void main(String[] args) {
        interfaceChild obj=new interfaceChild();
        obj.acc();
        obj.brake();
        obj.start();
        obj.stop();
        System.out.println(obj.a);
        interfaceA obj1=new interfaceChild();
        obj1.brake();
        
    }
}
