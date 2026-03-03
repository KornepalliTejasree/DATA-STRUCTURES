package Comparator;
import java.util.*;
public class BinaryFrquency {
    public static void main(String[] args) {
        int arr[]={0,1,2,3,4,5,6,7,8};
        Integer temp[]=new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp,(a,b)->{
            if(Integer.bitCount(a)<Integer.bitCount(b)){
                return -1;
            }
            else if(Integer.bitCount(a)>Integer.bitCount(b)){
                return 1;
            }
            return a-b;
        });
        System.out.println(Arrays.toString(temp));
    }
}
