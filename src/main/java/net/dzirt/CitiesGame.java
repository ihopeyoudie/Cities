package net.dzirt;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
        String nextCity = null;

        String playerCity;
        Boolean realCity;
        Boolean nextCityExist;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            playerCity = reader.readLine();
            realCity = map.cityInMap(playerCity);
            System.out.println("Real city: " + realCity);
            if(realCity) {
                Character nextChar = map.getNextCityChar(playerCity);
                System.out.println("next Char: " + nextChar);
                nextCityExist = map.nextCityExist(nextChar);
                System.out.println("next city exist: " + nextCityExist);
                if(nextCityExist) {
                    nextCity = map.getRandomCityByChar(nextChar);
                    map.removeCity(playerCity);
                    System.out.println("next city: " + nextCity);
                }
                else {
                    System.out.println("Game Over");
                    break;
                }
            }
            else {
                System.out.println("Game Over");
                break;
            }
        }
    }
}
