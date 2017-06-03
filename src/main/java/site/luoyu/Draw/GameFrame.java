package site.luoyu.Draw;

import site.luoyu.Core.RealCell;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class GameFrame extends JFrame{
    RealCell[][] arrays=null;
    int h;
    int w;
    int BLOCK_SIZE=30;
    int picHeight;
    int picWidth;
    int BODERSIZE=30;
    int BODERSIZESCALE=5;
    int SLIDERSIZE=40;
    JPanel panel = new JPanel(){
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.white);
            g.fillRect(0,0, picWidth, picHeight);
            g.setColor(Color.black);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //todo refactor
                    if(arrays[i][j].isAlive()){
                        int tx=i*BLOCK_SIZE;
                        int ty=j*BLOCK_SIZE;
                        g.fillRect(ty,tx,BLOCK_SIZE-BODERSIZESCALE,BLOCK_SIZE-BODERSIZESCALE);
                    }
                }

            }
        }
    };
    //Color black=new Color(0,0,0);
    //Color white=new Color(255,255,255);
    public GameFrame(RealCell[][] input){
        super("GAME OF LIFE");
        arrays=input;
        h=arrays.length;
        w=arrays[0].length;
//        picHeight=BLOCK_SIZE*h;
//        picWidth=BLOCK_SIZE*w;
        initIt();
    }

    private void initIt() {

        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        picWidth =(int)screen.getWidth();
        picHeight =(int)screen.getHeight()-BODERSIZE-SLIDERSIZE;
        int w1=(int)(picWidth /w);
        int h1=(int)(picHeight /h);
        BLOCK_SIZE=w1<h1?w1:h1;
        BODERSIZESCALE=(BLOCK_SIZE/10);
        //if(BODERSIZESCALE==0)
           // BODERSIZESCALE=1;
        setSize(picWidth, picHeight +BODERSIZE+SLIDERSIZE);
        setVisible(true);
        setResizable(false);
        panel.setSize(picWidth, picHeight);
        this.add(panel,BorderLayout.CENTER);
        //create speed ctl
        JSlider slider = new JSlider(1,300);
        ChangeListener listener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
                JSlider source = (JSlider) event.getSource();
                double scales=(source.getValue())*1.0/(picWidth -20);
                freshTime=(int)(scales*2000);
            }
        };
        panel.setLayout(null);
        slider.addChangeListener(listener);
        slider.setBounds(0, picHeight, picWidth -20,SLIDERSIZE);
        slider.setOpaque(false);

        panel.add(slider);
    }
    int freshTime=500;
    public void fresh(RealCell[][] a){
        arrays=a;
        repaint();
        try {

            Thread.sleep(freshTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
