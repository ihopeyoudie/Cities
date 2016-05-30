package net.dzirt;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Dzirt on 29.05.2016.
 */
public class CitiesGame {
    CitiesMap map;
    public void gameInit(String filePath){
        map = new CitiesMap();
        File f = new File(filePath);
        map.buildMap(f);
    }
    public void gameStart() throws Exception{
        String compCity = null;

        String playerCity;
        Boolean realCity;
        Boolean nextCityExist;

        Character nextCityChar;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        for (int i = 0; i < 10; i++) {
//            playerCity = reader.readLine();
//            realCity = map.cityInMap(playerCity);
//            System.out.println("Real city: " + realCity);
//            if(realCity) {
//                Character nextChar = map.getNextCityChar(playerCity);
//                System.out.println("next Char: " + nextChar);
//                nextCityExist = map.nextCityExist(nextChar);
//                System.out.println("next city exist: " + nextCityExist);
//                if(nextCityExist) {
//                    nextCity = map.getRandomCityByChar(nextChar);
//                    map.removeCity(playerCity);
//                    System.out.println("next city: " + nextCity);
//                }
//                else {
//                    System.out.println("Game Over");
//                    break;
//                }
//            }
//            else {
//                System.out.println("Game Over");
//                break;
//            }
//        }

        boolean gameFlag = true;
        while (gameFlag){
            System.out.println("Введите название города: ");
            playerCity = reader.readLine().toUpperCase();
            if (compCity != null){
                if(playerCity.charAt(0) != map.getNextCityChar(compCity)){
                    System.out.println("Не соответствует буква, введите еще раз: ");
                    continue;
                }
            }
            if(!map.cityInMap(playerCity)){
                System.out.println("Города нет в списке, введите еще раз: ");
                continue;
            }
            map.removeCity(playerCity);
            nextCityChar = map.getNextCityChar(playerCity);
            System.out.println("Следующая буква: "+ nextCityChar);
            if(!map.nextCityExist(nextCityChar)){
                gameFlag = false;
                System.out.println("Game over, player wins");
                continue;
            }
            compCity = map.getRandomCityByChar(nextCityChar);
            System.out.println("Компьютер выбрал город: ");
            System.out.println(compCity);
            map.removeCity(compCity);
            nextCityChar = map.getNextCityChar(compCity);
            if(!map.nextCityExist(nextCityChar)){
                gameFlag = false;
                System.out.println("Game over, computer wins");
                continue;
            }
            System.out.println("Ввеите город на букву "+ nextCityChar);
        }


    }
}
