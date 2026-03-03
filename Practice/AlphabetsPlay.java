package Practice;

import java.util.Scanner;

public class AlphabetsPlay {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
         char j=(char)((c[i]-'a'-5+26)%26+'a');
         System.out.println(j);
        }
        sc.close();
    }
}
