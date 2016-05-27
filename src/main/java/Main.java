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
        CitiesMap map = new CitiesMap();
        File f = new File("D:\\java\\projects\\Cities\\src\\main\\resources\\cities.txt");
        map.buildMap(f);
        map.printMap();
    }
}
