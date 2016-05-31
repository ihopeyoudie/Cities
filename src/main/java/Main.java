import net.dzirt.CitiesGame;

/**
 * Created by Dzirt on 26.05.2016.
 */
public class Main {
    public static void main(String[] args) {
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
