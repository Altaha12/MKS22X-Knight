import java.util.Comparator;
public class data implements Comparable<data> {
  private int[] location;
  private int paths;
  public data(int pathsa, int row, int col){
    location= new int[]{row,col};
    paths=pathsa;}
  public int getpaths(){return paths;}
  public int[] getlocation(){return location;}
  public int compareTo(data otro){
    if(otro.getpaths()<this.getpaths())return 1;
    if(otro.getpaths()==this.getpaths())return 0;
    return -1;
  }
}
