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
        MainFrame mainFrame = new MainFrame();
        mainFrame.initComponents();
        //mainFrame.setVisible(true);

        CitiesGame game = new CitiesGame();
        game.gameInit("D:\\java\\projects\\Cities\\src\\main\\resources\\cities.txt");

        try{
            game.gameStart();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
