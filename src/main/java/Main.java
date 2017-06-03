import site.luoyu.Core.Game;

/**
 * Created by luoyu on 2017/6/3 0003.
 */
public class Main {
    public static void main(String[] args) {

        Game game=new Game();
        game.initFromFile("input.txt");
        game.start(0);
    }
}
