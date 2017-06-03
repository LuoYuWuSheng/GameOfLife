package site.luoyu.Draw;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class GameFrame extends JFrame{
    int[][] arrays=null;
    int h;
    int w;
    int BLOCK_SIZE=30;
    int picH;
    int picW;
    int BODERSIZE=30;
    int BODERSIZESCALE=5;
    int SLIDERSIZE=40;
    JPanel panel = new JPanel(){
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.white);
            g.fillRect(0,0,picW,picH);
            g.setColor(Color.black);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //todo refactor
                    if(arrays[i][j]==1){
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
    public GameFrame(int[][] input){
        super("GAME OF LIFE");
        arrays=input;
        h=arrays.length;
        w=arrays[0].length;
//        picH=BLOCK_SIZE*h;
//        picW=BLOCK_SIZE*w;
        initIt();
    }

    private void initIt() {

        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        picW=(int)screen.getWidth();
        picH=(int)screen.getHeight()-BODERSIZE-SLIDERSIZE;
        int w1=(int)(picW/w);
        int h1=(int)(picH/h);
        BLOCK_SIZE=w1<h1?w1:h1;
        BODERSIZESCALE=(BLOCK_SIZE/10);
        setSize(picW,picH+BODERSIZE+SLIDERSIZE);
        setVisible(true);
        //setResizable(false);
        //this.setLayout();
        panel.setSize(picW,picH);
        this.add(panel,BorderLayout.CENTER);
//        this.pack();
        //create speed ctl
        JSlider slider = new JSlider(1,300);
        ChangeListener listener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
                //取出滑动条的值，并在文本中显示出来
                JSlider source = (JSlider) event.getSource();
                double scales=(source.getValue())*1.0/(picW-20);
                freshTime=(int)(scales*2000);
                //System.out.println(source.getValue());
            }
        };
        panel.setLayout(null);
        slider.addChangeListener(listener);
        slider.setBounds(0,picH,picW-20,SLIDERSIZE);
        slider.setOpaque(false);

        panel.add(slider);
    }
    int freshTime=500;
    public void fresh(int[][] a){
        arrays=a;
        repaint();
        try {

            Thread.sleep(freshTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
