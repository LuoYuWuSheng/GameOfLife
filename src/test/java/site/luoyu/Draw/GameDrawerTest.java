package site.luoyu.Draw;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class GameDrawerTest {
    private GameDrawer drawer;
    @Before
    public void init(){
        drawer = new GameDrawer();
    }
    @Test
    public void initGameFrameFromArray() throws Exception {
        int[][] data = new int[][]{{1,0,0},{0,0,0},{0,0,0}};
        drawer.initGameFrameFromArray(data);
//        System.out.println("");
        while (true);
    }

}