package site.luoyu.Draw;

import org.junit.Before;
import org.junit.Test;
import site.luoyu.Core.RealCell;

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
        RealCell[][] data = new RealCell[3][3];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = new RealCell();
                if(i == j)data[i][j].alive = true;
                else data[i][j].alive = false;
            }
        }

        drawer.initGameFrameFromArray(data);

    }

}