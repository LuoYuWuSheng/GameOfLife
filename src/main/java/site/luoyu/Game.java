package site.luoyu;

import javax.print.attribute.standard.Fidelity;
import java.io.File;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class Game {
    private int height, width;
    private int speed = 1;
    int[][] graph;
    int[][] temp;

    public Game(int height, int width) {
        this.height = height;
        this.width = width;
        this.graph = new int[height][width];
        this.temp = new int[height][width];
    }

    private void initFromArray() {
    }

    private void initFromFile(String path) {
        File input = new File(path);

    }

    private void grow() {

    }

    private void calc(){

    }

    private void print(){}

    public void start(int generation){
        initFromFile("input.txt");
        if(generation == 0){
            while (true){
                grow();
                print();
            }
        }else {
            for (int i = 0; i < generation; i++) {
                grow();
                print();
            }
        }
    }

}
