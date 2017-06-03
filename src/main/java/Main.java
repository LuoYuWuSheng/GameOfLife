import site.luoyu.Core.Game;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class Main {
    public static void main(String[] args) {

        int[][] a=new int[500][500];
        for(int i=0;i<500;i++)
            a[i][300]=1;

        Game game=new Game();
        //game.initFromFile("input.txt");
        game.initFromArray(500,500,a);
        game.start(0);
    }
}
