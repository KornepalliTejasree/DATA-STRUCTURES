package OOPS;

public class CustomException extends Exception{
    public CustomException(String msg){
        super(msg);
    }
}
class Main{
    public static void check(int n) throws CustomException{
        if(n<18){
            throw new CustomException("Age thakkuva ra");
        }
        System.out.println("Vote veyipora");
    }
    public static void main(String[] args) {
        int n=19;
        try{
            check(n);
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Ika vellu");
        }
        System.out.println("Time ayipoyindi");
    }
}