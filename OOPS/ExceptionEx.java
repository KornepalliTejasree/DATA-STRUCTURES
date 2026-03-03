package OOPS;

public class ExceptionEx {
    public static void main(String[] args) {
        int a=5;
        int b=0;
        //int c=a/b;
        try{
            //if(b==0) throw new ArithmeticException("Exceptionnnnnnnn");
            int c=divide(a, b);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("THis wil always exceute");
        }
        System.out.println("Im outside");
    }
    static int divide(int a,int b) throws ArithmeticException{
        if(b==0) throw new ArithmeticException("Exception vacchindi");
        return a/b;
    }
}
