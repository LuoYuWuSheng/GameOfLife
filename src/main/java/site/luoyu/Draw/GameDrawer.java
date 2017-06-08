package site.luoyu.Draw;

import site.luoyu.Core.RealCell;

import javax.swing.*;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class GameDrawer {
    GameFrame gameFrame = null;

    public GameDrawer() {
    }

    public void initGameFrameFromArray(RealCell[][] a) {
        gameFrame = new GameFrame(a);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void freshFrameByArray(RealCell[][] a){
        gameFrame.fresh(a);

    }


}
