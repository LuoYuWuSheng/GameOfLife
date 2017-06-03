package site.luoyu.Core;

import site.luoyu.Draw.GameDrawer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class Game {
    private int height, width;

    RealCell[][] graph;
    //int[][] temp;
    final int ALIVE=1;
    final int DIE=0;

    GameDrawer gameDrawer=null;

    public Game() {
    }

    public Game(int height, int width) {
        this.height = height;
        this.width = width;
        this.graph = new RealCell[height][width];
    }

    public void initFromArray(int height,int width,RealCell[][] data) {
        this.height = height;
        this.width = width;
        this.graph = data;
    }

    public void initFromFile(String path) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(path));
            Scanner sc = new Scanner(inputStream);
            this.height = sc.nextInt();
            this.width = sc.nextInt();
            this.graph = new RealCell[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    this.graph[i][j] = new RealCell();
                }
            }
            sc.nextLine();
            for (int i = 0; i < height; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < width; j++) {
                    graph[i][j].alive = (line.charAt(j)-'0')==1;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void grow() {
        calc();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (graph[i][j].count == 3)
                    graph[i][j].alive = true;
                else if (graph[i][j].count == 2) {
                    graph[i][j] = graph[i][j];
                } else {
                    graph[i][j].alive = false;
                }
                graph[i][j].count=0;
            }
        }
    }

    int[] dx = {0,  0,  1, 1, 1, -1, -1, -1};
    int[] dy = {1, -1, -1, 0, 1, -1,  0,  1};

    private void calc() {
        //this.temp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (graph[i][j].alive == true) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < height && ny >= 0 && ny < width)
                            graph[nx][ny].count++;
                    }
                }
            }
        }
    }

    public void print(int[][] array) {
        System.out.println("-----------------------------");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    private void paintByDrawer(){
        if(gameDrawer==null){
            gameDrawer=new GameDrawer();
            gameDrawer.initGameFrameFromArray(graph);
        }
        else {
            gameDrawer.freshFrameByArray(graph);
        }
    }
    public void start(int generation) {
        while (generation==0) {
            grow();
            //print(graph);
            paintByDrawer();
        }
        for (int i = 0; i < generation; i++) {
            grow();
            //print(graph);
            paintByDrawer();
        }
    }

}
