package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Revision {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public static boolean find(int arr[],int target,int index){
        if(index==arr.length){
            return false;
        }
        if(arr[index]==target){
            return true;
        }
        return find(arr, target, index+1);
    }
    public static int findIndex(int arr[],int target,int index){
        if(arr.length==index){
            return 0;
        }
        if(arr[index]==target){
            return index;
        }
        return findIndex(arr, target, index+1);
    }
    public static ArrayList<Integer> returnList(int arr[],int target,int index,ArrayList<Integer> l){
        if(arr.length==index){
            return l;
        }
        if(arr[index]==target){
            l.add(index);
        }
        returnList(arr, target, index+1, l);
        return l;
    }
    public static ArrayList<Integer> returnArrayList(int arr[],int target,int index){
        if(arr.length==index){
            ArrayList<Integer> l=new ArrayList<>();
            return l;
        }
        ArrayList<Integer> list=new ArrayList<>();
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> temp=returnArrayList(arr, target, index+1);
        temp.addAll(list);
        return temp;
    }
    public static void printPattern(int n){
        if(n==0){
            return;
        }
        for(int i=0;i<n;i++){
          System.out.print("* ");
       }  
          System.out.println();
          printPattern(n-1);
    }
    //String revision
    public static String skip(String p,String up,char c){
        if(up.isEmpty()){
            return p;
        }
        char ch=up.charAt(0);
        if(ch==c){
             return skip(p,up.substring(1),c);
        }
        else{
            return skip(p+ch,up.substring(1),c);
        }
    }
    public static String skipApple(String p,String up,String pat){
        if(up.isEmpty()){
            return p;
        }
        char ch=up.charAt(0);
        if(up.startsWith(pat)){
             return skipApple(p,up.substring(pat.length()),pat);
        }
        else{
            return skipApple(p+ch,up.substring(1),pat);
        }
    }
    public static void subsetSubsequence(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        subsetSubsequence(p+c, up.substring(1));
        subsetSubsequence(p, up.substring(1));
    }
    public static ArrayList<String> returnSubsetSubsubsequence(String p,String up){
          ArrayList<String> list=new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char c=up.charAt(0);
        ArrayList<String> l1=returnSubsetSubsubsequence(p+c, up.substring(1));
        ArrayList<String> l2=returnSubsetSubsubsequence(p, up.substring(1));
        l1.addAll(l2);
        return l1;
    }
    public static void subsetWithoutRecursion(int arr[]){
        list.add(new ArrayList<Integer>());
        for(int i=0;i<arr.length;i++){
            int n=list.size();
            for(int j=0;j<n;j++){
                ArrayList<Integer> l=new ArrayList<>(list.get(j));
                l.add(arr[i]);
                 list.add(l);
            }
           
        }
        System.out.println(list);
    }
    public static void permutationsString(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String start=p.substring(0, i);
            String end=p.substring(i);
            permutationsString(start+c+end, up.substring(1));
        }
    }
    public static void phoneNumber(String p,String up,String arr[]){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        int n=up.charAt(0)-'0';
        for(int i=0;i<arr[n].length();i++){
            char c=arr[n].charAt(i);
            phoneNumber(p+c, up.substring(1), arr);
        }
    }
    public static int phoneNumberCount(String p,String up,String arr[]){
        if(up.isEmpty()){
            return 1;
        }
        int n=up.charAt(0)-'0';
        int count=0;
        for(int i=0;i<arr[n].length();i++){
            char c=arr[n].charAt(i);
           count+= phoneNumberCount(p+c, up.substring(1), arr);
        }
        return count;
    }
    public static void ArrayPermutation(int arr[],int fi){
        if(fi==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=fi;i<arr.length;i++){
            swap(arr,i,fi);
            ArrayPermutation(arr, fi+1);
            swap(arr,i,fi);
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static int[] NextPermutation(int arr[]){
        int ele=-1;
         for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                ele=i-1;
            }
         }
         if(ele==-1){
            Arrays.sort(arr);
           return arr;
         }
         int subIndex=-1;
         for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[ele]){
                subIndex=i;
                break;
            }
         }
         swap(arr, ele, subIndex);
         reverse(arr,ele+1,arr.length-1);
         return arr;
    }
    public static void reverse(int arr[],int left,int right){
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public static void dice(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=6 && i<=target;i++){
            dice(p+i, target-i);
        }
    }
    //Maze Problems
    //1)Counting paths
    public static int countingPaths(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        return countingPaths(r-1, c)+countingPaths(r, c-1);
    }
    //2)Printing maze paths without diagonal
    public static void printPaths(int r,int c,String path){
        if(r==1 && c==1){
            System.out.println(path);
            return;
        }
       if(r>1) printPaths(r-1, c, path+"D");
       if(c>1)printPaths(r, c-1, path+"R");
    }
     //3)Printing maze paths with diagonal
    public static void printPathsDiagonal(int r,int c,String path){
        if(r==1 && c==1){
            System.out.println(path);
            return;
        }
       if(r>1) printPathsDiagonal(r-1, c, path+"D");
       if(c>1) printPathsDiagonal(r, c-1, path+"R");
       if(c>1 && r>1) printPathsDiagonal(r-1,c-1,path+"X"); 
    }
    //4)Maze with obstacles
    public static void mazeWithOstacles(boolean arr[][],int r,int c,String path){
        if(r==arr.length-1 && c==arr.length-1){
            System.out.println(path);
            return;
        }
        if(arr[r][c])return;
       if(r<arr.length-1)mazeWithOstacles(arr, r+1, c, path+"D");
       if(c<arr.length-1) mazeWithOstacles(arr, r, c+1, path+"R");
       if(c<arr.length-1 && r<arr.length-1) mazeWithOstacles(arr, r+1, c+1, path+"X");
    }
    public static void printAllPaths(boolean arr[][],int r,int c,String path){
        if(r==arr.length-1 && c==arr.length-1){
            System.out.println(path);
            return;
        }
        if(arr[r][c])return;
        arr[r][c]=true;
        if(r<arr.length-1)printAllPaths(arr, r+1, c, path+"D");
       if(c<arr.length-1) printAllPaths(arr, r, c+1, path+"R");
       if(r>0) printAllPaths(arr, r-1, c, path+"U");
       if(c>0)printAllPaths(arr, r, c-1, path+"L");
       arr[r][c]=false;

    }
    public static void nQueens(boolean board[][],int row){
        if(row==board.length){
            display(board);
            System.out.println();
            return;
        }
        for(int col=0;col<board.length;col++){
            if(check(board,row,col)){
                board[row][col]=true;
                nQueens(board, row+1);
                board[row][col]=false;
            }
        }
    }
    public static boolean check(boolean board[][],int r,int c){
        //check vertically
        for(int i=0;i<board.length;i++){
            if(board[i][c])return false;
        }
        //check horizontally
        int maxleft=Math.min(r,c);
        for(int i=1;i<=maxleft;i++){
            if(board[r-i][c-i])return false;
        }
        int maxright=Math.min(r,board.length-1-c);
        for(int i=1;i<=maxright;i++){
            if(board[r-i][c+i])return false;
        }
        return true;
    }
    public static void display(boolean board[][]){
        for(boolean[] i:board){
            for(boolean j:i){
                if(j==true){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    public static boolean suduko(int board[][]){
        int row=-1;
        int col=-1;
        boolean emptyLeft=true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                }
            }
            if(emptyLeft==false){
                break;
            }
        }
        if(emptyLeft==true)return true;
        for(int i=1;i<=9;i++){
            if(isSafe(board, row, col,i)){
                board[row][col]=i;
                if(suduko(board)){
                    return true;
                }
                else{
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
    public static boolean isSafe(int board[][],int r,int c,int n){
        //check rows
        for(int i=0;i<board.length;i++){
            if(board[r][i]==n)return false;
        }
        //check columns
        for(int i=0;i<board.length;i++){
            if(board[i][c]==n)return false;
        }
        //check matrix
        int sqrt=(int)Math.sqrt(board.length);
        int left=r-r%sqrt;
        int right=c-c%sqrt;
        for(int i=left;i<left+sqrt;i++){
            for(int j=right;j<right+sqrt;j++){
                if(board[i][j]==n)return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[]={1,2};
        System.out.println(find(arr, 11, 0));
        System.out.println(findIndex(arr, 5, 0));
        System.out.println(returnList(arr, 4, 0, new ArrayList<>()));
        System.out.println(returnArrayList(arr, 4, 0));
        printPattern(4);
        System.out.println(skip("", "Abcd", 'c'));
        System.out.println(skipApple("", "asjlijapplenjd", "apple"));
        subsetSubsequence("", "abc");
        System.out.println(returnSubsetSubsubsequence("", "abc"));
        subsetWithoutRecursion(arr);
        System.out.println("See permutaions of String:");
        permutationsString("", "abc");
        String s[]={"","","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
        System.out.println("PhoneNumber");
        phoneNumber("", "28", s);
        System.out.println("PhoneNumber count:");
        System.out.println(phoneNumberCount("", "27", s));
        System.out.println("See Array Permutation");
        ArrayPermutation(arr, 0);
        System.out.println("Next Permutation:");
        int arr1[]=NextPermutation(arr);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Dice roll");
        dice("", 5);
        System.out.println("Number of Paths is:"+countingPaths(3, 3));
        System.out.println("Printing maze paths");
        printPaths(3, 3, "");
        System.out.println("Printing paths with diagonals");
        printPathsDiagonal(3, 3, "");
        boolean maze[][]=new boolean[4][4];
        maze[1][1]=true;
        System.out.println("Maze with obstacles");
        mazeWithOstacles(maze, 0, 0, "");
        maze[1][1]=false;
        System.out.println("Printing all paths");
        printAllPaths(maze, 0, 0, "");
        System.out.println("N-Queens");
        nQueens(maze, 0);

    }
}
