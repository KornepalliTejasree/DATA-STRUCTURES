package Recursion;
public class NQueens {
    public static void main(String[] args) {
        int n=1;
        boolean board[][]=new boolean[n][n];
        System.out.println(queens(board, 0));
    }
   public static int queens(boolean board[][],int row){
    if(row==board.length){
        display(board);
        System.out.println();
        return 1;
    }
    int count=0;
    for(int col=0;col<board.length;col++){
        if(check(board,row,col)){
            board[row][col]=true;
           count+= queens(board, row+1);
            board[row][col]=false;
        }
    }
    return count;
   }
   public static void display(boolean board[][]){
    for(boolean[] arr:board){
        for(boolean i:arr){
            if(i){
                System.out.print("Q ");
            }
            else{
                System.out.print("X ");
            }
        }
        System.out.println();
    }
   }
   public static boolean check(boolean board[][],int r,int c){
    //vertical checking
    //We will check until row(or above row) because no need to check below values
    for(int i=0;i<r;i++){
        if(board[i][c]){
            return false;
        }
    }
    //left diagonal
    //find the min among row and column
    //If you travel towards left then both col and row will decrease
    int maxLeft=Math.min(r,c);
    for(int i=1;i<=maxLeft;i++){
        if(board[r-i][c-i]){
            return false;
        }
    }
    //right diagonal
    //find the min among row and distance from the board.length to current column-1
   int maxRight=Math.min(r,board.length-c-1);
   for(int i=1;i<=maxRight;i++){
    if(board[r-i][c+i]){
        return false;
    }
   }
   return true;
   }
}
