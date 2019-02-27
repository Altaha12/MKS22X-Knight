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
  public boolean solve(int startingRow, int startingCol) throws IllegalStateException,IllegalArgumentException{
    //checks Illegal State Exception
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]!=0)throw new IllegalStateException();
      }
    }
    if(startingRow<0||startingRow>=board.length||startingCol<0||startingCol>=board[0].length)throw new IllegalArgumentException();
    return solveH(startingRow,startingCol,1);
  }
  //starts at row and column and goes down tree of all possibles in order of least moves possible there
  private boolean solveH(int row, int col, int move){
    return true;
  }
  //gives a list of possibles sorted by number of paths
  private int[][] possibles(int row, int col){
    return board;
  }
  //gives number of possibles from a given square
  private int possiblesCount(int row, int col){
    int[][] moves= new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    int count=0;
    for(int[] i : moves ){
      if(possible(row+i[0], col+i[1]))count+=1;
    }
    return count;
  }
  //returns if a given square is possible
  private boolean possible(int row,int col){
    return row>=0&&col>=0&&row<board.length&&col<board[0].length&&board[row][col]==0;
  }
  public static void main(String[] args) {
    KnightBoard A = new KnightBoard(8,8);
    A.board[4][2]=1;
    System.out.println(A.possiblesCount(0,0));
    System.out.println(A.possiblesCount(0,2));
    System.out.println(A.possiblesCount(3,4));

}
}
