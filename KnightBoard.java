import java.io.File;
import java.util.Arrays;
public class KnightBoard{
  private int[][] board;
  public KnightBoard(int rows, int cols)throws IllegalArgumentException{
  //rows first index, cols second index
    if(rows<=0||cols<=0) throw new IllegalArgumentException();
    board=new int[rows][cols];
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        board[i][j]=0;
      }
    }
  }
  public String toString(){
    String brd="";
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
          if(board[i][j]<10)brd+=" ";
            if(board[i][j]==0)brd+="_";
            else brd+=board[i][j];
           brd+=" ";
          }
        brd = brd.substring(0, brd.length() - 1);
        brd+="\n";
      }
    return brd;
    }
  public static void main(String[] args) {
    System.out.println("Testing the Constructor");

    KnightBoard A=new KnightBoard(1,2);
    System.out.println("This is a 1 by 2 board");
    System.out.print(A);

    KnightBoard B=new KnightBoard(3,4);
    System.out.println("This is a 3 by 4 board");
    System.out.print(B);

    KnightBoard C=new KnightBoard(8,8);
    System.out.println("This is a 8 by 8 board");
    System.out.print(C);
    int x=0;
    for(int row=0;row<C.board.length;row++){
      for(int col=0;col<C.board[0].length;col++){
        C.board[row][col]=x;
        x+=1;
      }

    }
    System.out.println("This is a 8 by 8 board With single and double digit numbers");
    System.out.print(C);

  }


}
