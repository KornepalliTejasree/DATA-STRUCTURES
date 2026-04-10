package Recursion;
import java.util.*;
public class RecursionPractice {
    //Subset subsequence
    public static void subsequence(String process,String uprocess){
        if(uprocess.isEmpty()){
            System.out.println(process);
            return;
        }
        char c=uprocess.charAt(0);
        subsequence(process+c, uprocess.substring(1));
        subsequence(process, uprocess.substring(1));
    }
    public static ArrayList<ArrayList<Integer>> subsequencesWithoutRecursion(int arr[]){
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i:arr){
            int size=list.size();
            for(int j=0;j<size;j++){
                ArrayList<Integer> l=new ArrayList<>(list.get(j));
                l.add(i);
                list.add(l);
            }
             
        }
        return list;
    }
    public static void permutations(int arr[],int fi){
        if(fi==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=fi;i<arr.length;i++){
            swap(i,fi,arr);
            permutations(arr, fi+1);
            swap(i,fi,arr);
        }
    }
    public static void StringPermutations(char arr[],int fi){
        if(fi==arr.length){

            String s=new String(arr);
            System.out.println(s);
            return;
        }
        for(int i=fi;i<arr.length;i++){
            swaping(i,fi,arr);
            StringPermutations(arr, fi+1);
            swaping(i,fi,arr);
        }
    }
    public static void swaping(int i,int j,char arr[]){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void swap(int i,int j,int arr[]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void skipCharacters(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        if(c=='a'){
            skipCharacters(p, up.substring(1));
        }
        else{
            skipCharacters(p+c, up.substring(1));
        }
    }
    public static void skipword(String p,String up,String pat){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        if(up.startsWith(pat)){
            skipword(p,up.substring(pat.length()),pat);
        }
        else{
            skipword(p+c,up.substring(1),pat);
        }
    }
    public static void phoneNumbers(String p,String up,String arr[]){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int n=up.charAt(0)-'0';
        for(int i=0;i<arr[n].length();i++){
            char c=arr[n].charAt(i);
            phoneNumbers(p+c, up.substring(1), arr);
        }
    }
    public static void dice(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=target && i<=6;i++){
            dice(p+i,target-i);
        }
    }
    //Maze problems
    public static int countingPaths(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        return countingPaths(r-1, c)+countingPaths(r, c-1);
    }
    public static void PrintPaths(int r,int c,String path){
        if(r==1 && c==1){
            System.out.println(path);
            return;
        }
        if(r>1)PrintPaths(r-1,c,path+"D");
        if(c>1)PrintPaths(r, c-1,path+"R");
    }
    public static void printingPathsDiagonal(int r,int c,String path){
        if(r==1 && c==1){
            System.out.println(path);
            return;
        }
        if(r>1)printingPathsDiagonal(r-1, c, path+"D");
        if(c>1)printingPathsDiagonal(r, c-1, path+"R");
        if(c>1 && r>1)printingPathsDiagonal(r-1, c-1, path+"X");
    }
    public static void mazeWithObstacles(boolean maze[][],int r,int c,String path){
        if(r==maze.length-1 && c==maze.length-1){
            System.out.println(path);
            return;
        }
        if(maze[r][c])return;
        maze[r][c]=true;
        if(r<maze.length-1){
            mazeWithObstacles(maze,r+1,c,path+"D");
        }
        if(c<maze.length-1){
            mazeWithObstacles(maze, r, c+1, path+"R");
        }
        maze[r][c]=false;
    }
    public static void fourPaths(boolean maze[][],int r,int c,String Path){
        if(r==maze.length-1 && c==maze.length-1){
            System.out.println(Path);
            return;
        }
        if(maze[r][c])return;
        maze[r][c]=true;
        if(r<maze.length-1)fourPaths(maze, r+1, c, Path+"D");
        if(c<maze.length-1)fourPaths(maze, r, c+1, Path+"R");
        if(r>0)fourPaths(maze, r-1, c, Path+"U");
        if(c>0)fourPaths(maze, r, c-1, Path+"L");
        maze[r][c]=false;
    }
    
    public static void main(String args[]){
        subsequence("", "abc");
        int arr[]={1,2,3};
        ArrayList<ArrayList<Integer>> list=subsequencesWithoutRecursion(arr);
        System.out.println(list);
        permutations(arr, 0);
        char c[]={'a','b','c'};
        StringPermutations(c,0);
        skipCharacters("", "baaccddd");
        skipword("","apappleapap","apple");
        String numbers[]={"","","abc","def","ghi","jklm","nopq","rst","uvw","xyz"};
        phoneNumbers("", "24", numbers);
        dice("",4);
        countingPaths(3, 3);
        PrintPaths(3,3,"");
        System.out.println("Including diagonals:");
        printingPathsDiagonal(3, 3, "");
        System.out.println("Maze with obstacles:");
        mazeWithObstacles(new boolean[3][3], 0, 0, "");
        System.out.println("Four paths");
        fourPaths(new boolean[3][3], 0, 0, "");
    }
}
