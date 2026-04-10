package Recursion;

public class NQueensI {
    public static void main(String[] args) {
        int n=8;
        boolean board[][]=new boolean[n][n];
        queens(board,0);
    }
    public static void queens(boolean board[][],int row){
        if(row==board.length){
            display(board);
            System.out.println();
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                queens(board, row+1);
                board[row][col]=false;
            }
        }
    }
    public static boolean isSafe(boolean board[][],int row,int col){
         //check vertically
         for(int i=0;i<board.length;i++){
            if(board[i][col])
            {
                return false;
            }
         }
         //check left diagonal
         int maxLeft=Math.min(row,col);
         for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
         }
         //check right diagonal
         int maxright=Math.min(row,board.length-col-1);
         for(int i=1;i<=maxright;i++){
            if(board[row-i][col+i]){
                return false;
            }
         }
         return true;
    }
    public static void display(boolean board[][]){
        for(boolean[] row:board){
            for(boolean i:row){
                if(i==true){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
