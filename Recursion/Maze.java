package Recursion;

import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        System.out.println(maze(3, 3));
        printingPaths(3, 3, "");
        System.out.println("Printing Diagonally");
        printingPathsDiagonal(3, 3, "");
       boolean visited[][] = new boolean[3][3];
       System.out.println("All paths Up and down and stuff");
       fourPaths(visited, 0, 0, "");

      boolean maze[][] = new boolean[3][3];
     maze[1][1] = true;
     System.out.println("Maze with obstacles");
    mazeWithObstacles(maze, 0, 0, "");
        int matrix[][]=new int[3][3];
        System.out.println("Printing the whole matrix and the corresponding paths");
        printMatrixPaths(matrix, 1, 0, 0, " ");
       
    }
    public static int maze(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        return maze(r-1, c)+maze(r, c-1);
    }
    public static void printingPaths(int r,int c,String p){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
       if(r>1) printingPaths(r-1, c, p+"D");
       if(c>1) printingPaths(r, c-1, p+"R");
    }
    public static void printingPathsDiagonal(int r,int c,String p){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
       if(r>1) printingPathsDiagonal(r-1, c, p+"D");
       if(c>1) printingPathsDiagonal(r, c-1, p+"R");
       if(r>1 && c>1) printingPathsDiagonal(r-1, c-1, p+"@");
    }
    public static void mazeWithObstacles(boolean[][] maze,int r,int c,String path){
        if(r==maze.length-1 && c==maze.length-1){
            System.out.println(path);
            return;
        }
        if(maze[r][c]==true)return;
         if(r<maze.length-1) mazeWithObstacles(maze, r+1, c, path+"D");
       if(c<maze.length-1) mazeWithObstacles(maze, r, c+1, path+"R");
}
    public static void fourPaths(boolean[][] maze,int r,int c,String path ){
        if(r==maze.length-1 && c==maze[0].length - 1){
            System.out.println(path);
            return;
        }
       if(maze[r][c])return;
       maze[r][c]=true;
       if(r<maze.length-1){
        fourPaths(maze, r+1, c, path+"D");
       } 
       if(c<maze[0].length-1) {
        fourPaths(maze, r, c+1, path+"R");
       }
       if(r>0 ) {
        fourPaths(maze, r-1, c, path+"U");
       }
       if(c>0 ) {
        fourPaths(maze, r, c-1, path+"L");
       }
       maze[r][c]=false;
}
public static void printMatrixPaths(int[][] matrix,int step,int r,int c,String path){
    if(r==matrix.length-1 && c==matrix.length-1){
        printArray(matrix);
        System.out.println(path);
        return;
    }
    if(matrix[r][c]!=0) return;
    matrix[r][c]=step;
    if(r<matrix.length-1){
         printMatrixPaths(matrix, step+1, r+1, c, path+"D");
    }
    if(c<matrix.length-1){
         printMatrixPaths(matrix, step+1, r, c+1, path+"R");
    }
    if(r>0){
        printMatrixPaths(matrix, step+1, r-1, c, path+"U");
    }
    if(c>0){
        printMatrixPaths(matrix, step+1, r, c-1, path+"L");
    }
    matrix[r][c]=0;
}
public static void printArray(int arr[][]){
    for(int i=0;i<arr.length;i++){
        System.out.println(Arrays.toString(arr[i]));
    }
}
}