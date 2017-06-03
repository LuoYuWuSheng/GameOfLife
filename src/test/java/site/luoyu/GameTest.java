package site.luoyu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.luoyu.Core.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class GameTest {
    private Game game;

    @Before
    public void init() {
        this.game = new Game();
    }

    @After
    public void afther() {
    }

    @Test
    public void initFromFile() throws Exception {

    }

    @Test
    public void start() throws Exception {
        FileInputStream inputStream = null;
        int testCase =0;
        try {
            inputStream = new FileInputStream(new File("input.txt"));
            Scanner sc = new Scanner(inputStream);
            while (sc.hasNextLine()){
                int height = sc.nextInt();
                int width = sc.nextInt();
                int freshTime = sc.nextInt();
                int[][] graph = new int[height][width];
                sc.nextLine();
                for (int i = 0; i < height; i++) {
                    String line = sc.nextLine();
                    for (int j = 0; j < width; j++) {
                        graph[i][j] = line.charAt(j)-'0';
                    }
                }
                //game.initFromArray(height,width,graph);

                System.out.format("===========Case : %d =========",testCase++).println();
                //game.start(3);
            }
            //print(graph);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
        }

    }

}