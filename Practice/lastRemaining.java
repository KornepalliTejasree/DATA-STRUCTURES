package Practice;
import java.util.*;
class lastRemaining {
    public static int func(int n) {
        if(n==0)return 0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        change(list, 0);
        return list.get(0);
    }
    public static void change(ArrayList<Integer> list,int left){
        if(list.size()==1){
            return;
        }
       
       if(left==0){
        for(int i=left;i<list.size();i+=2){
        list.remove(i);
       }
       left=list.size()-1;
       }
       else{
        for(int i=left;i>=0;i-=2){
        list.remove(i);
       }
       left=0;
       }
       change(list, left);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(func(n));
    }
}