package site.luoyu.Draw;

import javax.swing.*;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class GameDrawer {
    GameFrame gameFrame = null;


    int freshTime = 1000;

    public GameDrawer(int freshTime) {
        this.freshTime = freshTime;
    }

    public void initGameFrameFromArray(int[][] a) {
        gameFrame = new GameFrame(a);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void freshFrameByArray(int[][] a){
        gameFrame.fresh(a);
        try {
            Thread.sleep(freshTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void setFreshTime(int freshTime) {
        this.freshTime = freshTime;
    }

    public int getFreshTime() {
        return freshTime;
    }

}
