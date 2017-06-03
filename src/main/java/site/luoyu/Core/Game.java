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
    private int speed = 1;
    int[][] graph;
    int[][] temp;
    GameDrawer gameDrawer=null;

    public int getFreshTime() {
        return freshTime;
    }

    public void setFreshTime(int freshTime) {
        this.freshTime = freshTime;
    }

    int freshTime=1000;
    public Game() {
    }

    public Game(int height, int width,int freshTime) {
        this.height = height;
        this.width = width;
        this.freshTime = freshTime;
        this.graph = new int[height][width];
        //this.temp = new int[height][width];
    }

    public void initFromArray(int height,int width,int[][] data) {
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
            this.graph = new int[height][width];
            sc.nextLine();
            for (int i = 0; i < height; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < width; j++) {
                    graph[i][j] = line.charAt(j)-'0';
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
                if (temp[i][j] == 3)
                    graph[i][j] = 1;
                else if (temp[i][j] == 2) {
                    graph[i][j] = graph[i][j];
                } else {
                    graph[i][j] = 0;
                }
            }
        }
    }

    int[] dx = {0,  0,  1, 1, 1, -1, -1, -1};
    int[] dy = {1, -1, -1, 0, 1, -1,  0,  1};

    private void calc() {
        this.temp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (graph[i][j] == 1) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < height && ny >= 0 && ny < width)
                            temp[nx][ny]++;
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
            gameDrawer=new GameDrawer(freshTime);
            gameDrawer.initGameFrameFromArray(graph);
        }
        else {
            gameDrawer.freshFrameByArray(graph);
        }
    }
    public void start(int generation) {
        //initFromFile("input.txt");
        while (generation==0) {
            grow();
            print(graph);
            paintByDrawer();
        }
        for (int i = 0; i < generation; i++) {
            grow();
            print(graph);
            paintByDrawer();
        }
    }

}
