package OOPS;

public class Box {
    double l;
    double w;
    double b;
    Box(){
        super();
        this.l=-1;
        this.b=-1;
        this.w=-1;
    }
    Box(double l,double w,double b){
        this.l=l;
        this.b=b;
        this.w=w;
    }
    Box(Box other){
        this.l=other.l;
        this.b=other.b;
        this.w=other.w;
    }
    static void hell(){
    System.out.println("Welcome to the box");
   }
}
