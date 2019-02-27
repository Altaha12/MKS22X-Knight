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
    boolean ff =solveH(startingRow,startingCol,1);
    if(!ff){
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
          board[i][j]=0;
        }
      }
    }
    return ff;
  }
  //copy of solve but with helper set to solveH1, determines number of solutions
  public int countSolutions(int startingRow, int startingCol) throws IllegalStateException,IllegalArgumentException{
    //checks Illegal State Exception
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]!=0)throw new IllegalStateException();
      }
    }
    if(startingRow<0||startingRow>=board.length||startingCol<0||startingCol>=board[0].length)throw new IllegalArgumentException();
    int s =solveH1(startingRow,startingCol,1,0);
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        board[i][j]=0;
      }}
    return s;
  }
  //copy of solveH adjusted to determine count
  private int solveH1(int row, int col, int move,int count){
    board[row][col]=move;
    int[][] x= possibles(row,col);
    if(move==board.length*board[0].length) return 1;
    if(x.length==0)return 0;
    for(int[] i : x){
      count+=solveH1(i[0],i[1],move+1,0);
      board[i[0]][i[1]]=0;
    }
    return count;
  }
  //Recursive backtracking, most work, starts at row and column and goes down tree of all possibles in order of least moves possible there
  private boolean solveH(int row, int col, int move){
    board[row][col]=move;
    int[][] x= possibles(row,col);
    if(move==board.length*board[0].length) return true;
    if(x.length==0)return false;
    for(int[] i : x){
      boolean thispath = solveH(i[0],i[1],move+1);
      if(thispath) return true;
      board[i[0]][i[1]]=0;
    }
    return false;
  }
  //gives a list of possibles sorted by number of paths
  private int[][] possibles(int row, int col){
    int[][] moves= new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    int ss=possiblesCount(row,col);
    data[] movess= new data[ss];
    int index=0;
    for(int[] i : moves){
      if(possible(row+i[0], col+i[1])){
        movess[index]=new data(possiblesCount(row+i[0], col+i[1]),row+i[0], col+i[1]);
        index+=1;}
    }
    Arrays.sort(movess);
    int[][] tbr=new int[ss][2];
    for(int i=0;i<movess.length;i++){
      tbr[i]=movess[i].getlocation();
    }
    return tbr;
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
    KnightBoard A = new KnightBoard(4,6);
    System.out.println("Testing Solver");
    System.out.println("Here's the Blank Board at the Start:");
    System.out.print(A);
    int w = A.countSolutions(0,0);
    boolean f  = A.solve(0,0);
    if(f){
      System.out.println("There are "+w+" possible answers if you start at (0,0) \n Here's one of Them");
      System.out.print(A);
    }
    else{
      System.out.println("Couldn't find an answer");
      System.out.print(A);
    }

}
}
