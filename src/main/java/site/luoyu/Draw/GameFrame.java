package site.luoyu.Draw;

import javax.swing.*;
import java.awt.*;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class GameFrame extends JFrame{
    int[][] arrays=null;
    int h;
    int w;
    final int BLOCK_SIZE=30;
    int picH;
    int picW;
    JPanel panel = new JPanel(){
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.white);
            g.fillRect(0,0,picW,picH);
            g.setColor(Color.black);
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    //todo refactor
                    if(arrays[i][j]==1){
                        int tx=i*BLOCK_SIZE;
                        int ty=j*BLOCK_SIZE;
                        g.fillRect(tx,ty,BLOCK_SIZE,BLOCK_SIZE);
                    }
                }

            }
        }
    };
    //Color black=new Color(0,0,0);
    //Color white=new Color(255,255,255);
    public GameFrame(int[][] input){
        super("GAME OF LIFE");
        arrays=input;
        h=arrays.length;
        w=arrays[0].length;
        picH=BLOCK_SIZE*h;
        picW=BLOCK_SIZE*w;
        setSize(picW,picH);
        setVisible(true);
//        setResizable(false);
        this.add(panel);
    }
    public void fresh(int[][] a){
        arrays=a;
        repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
