package net.dzirt;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Dzirt on 29.05.2016.
 */
public class CitiesGame {
    CitiesMap map;
    public void gameInit(){
        map = new CitiesMap();
        File f = new File("D:\\java\\projects\\Cities\\src\\main\\resources\\cities.txt");
        map.buildMap(f);
    }
    public void gameStart() throws Exception{
        String nextCity;
        String playerCity;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        playerCity = reader.readLine();
        for (int i = 0; i < 5; i++) {

            System.out.println("Real city: " + map.cityInMap(playerCity));
            Character nextChar = map.getNextCityChar(playerCity);
            System.out.println("next Char: " + nextChar);
            System.out.println("next city exist: " + map.nextCityExist(nextChar));
            playerCity = map.getRandomCityByChar(nextChar);
            System.out.println("next city: " + playerCity);

        }
    }
}
