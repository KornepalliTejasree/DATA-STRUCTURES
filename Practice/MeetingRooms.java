package Practice;
import java.util.*;
public class MeetingRooms {
    public static void main(String[] args) {
        int arr[][]={{1,4},{10,15},{7,10}};
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        ArrayList<Integer> list=new ArrayList<>();
        for(int[] a:arr){
            list.add(a[0]);
            list.add(a[1]);
        }
        boolean isNotOverlapping=true;
        for(int i=1;i<list.size()-1;i+=2){
            if(list.get(i)>list.get(i+1)){
                isNotOverlapping=false;
            }
        }
        System.out.println(isNotOverlapping);
    }

}
