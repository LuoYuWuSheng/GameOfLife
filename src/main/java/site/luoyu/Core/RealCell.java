package site.luoyu.Core;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class RealCell implements Cell{
    //public static RealCell cells[][];
    //int x;
    //int y;
    public boolean alive = false;
    public int count = 0;
    public boolean isAlive() {
        return alive;
    }
    //public static RealCell getTop(RealCell curCell){
   //     return cells[curCell.x][curCell.y-1];
   // }

}
