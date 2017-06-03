import site.luoyu.Core.Game;
import site.luoyu.Core.RealCell;

import java.util.Random;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class Main {
    public static void main(String[] args) {

        int n=500;
        int m=500;
        RealCell[][] a = getTheArray(n,m,false);

        Game game=new Game();
        //game.initFromFile("input.txt");
        game.initFromArray(n,m,a);
        game.start(0);
    }

    public static RealCell[][] getTheArray(int n,int m,boolean x){
        RealCell[][] a=new RealCell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = new RealCell();
            }
        }
        for(int i=0;i<m;i++)
            a[n/2][i].alive=true;
//        if(x){
//            for (int i = 0; i < 5; i++) {
//                int xx = getRandomNum(m);
//                a[n/2][xx].alive=false;
//            }
//        }
        return a;
    }
    public static int getRandomNum(int max){
        int min=0;
        Random random = new Random();

        return  random.nextInt(max)%(max-min+1) + min;
    }
}
