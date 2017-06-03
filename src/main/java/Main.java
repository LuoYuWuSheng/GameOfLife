import site.luoyu.Core.Game;

import java.util.Random;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class Main {
    public static void main(String[] args) {

        int n=100;
        int m=100;
        int[][] a = getTheArray(n,m,true);

        Game game=new Game();
        //game.initFromFile("input.txt");
        game.initFromArray(n,m,a);
        game.start(0);
    }

    public static int[][] getTheArray(int n,int m,boolean x){
        int[][] a=new int[n][m];
        for(int i=0;i<m;i++)
            a[n/2][i]=1;
        if(x){
            for (int i = 0; i < 5; i++) {
                int xx = getRandomNum(m);
                a[n/2][xx]=0;
            }
        }
        return a;
    }
    public static int getRandomNum(int max){
        int min=0;
        Random random = new Random();

        return  random.nextInt(max)%(max-min+1) + min;
    }
}
