import net.dzirt.CitiesGame;
import net.dzirt.CitiesMap;
import net.dzirt.MainFrame;
import java.io.File;

/**
 * Created by Dzirt on 26.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        //MainFrame mainFrame = new MainFrame("GAME");
        //mainFrame.init();
        CitiesGame game = new CitiesGame();
        game.gameInit();
        try{
            game.gameStart();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
