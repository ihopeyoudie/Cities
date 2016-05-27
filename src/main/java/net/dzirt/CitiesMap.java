package net.dzirt;

import java.io.*;
import java.util.*;

/**
 * Created by Dzirt on 27.05.2016.
 */
public class CitiesMap {

    private Map<Character,HashSet<String>>  citiesMap = new TreeMap<>();

    public void buildMap(File file){
        for (char c = 'А'; c<='Я'; c++){
            citiesMap.put(c, new HashSet<String>());
        }

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String s;
            HashSet<String> tempSet;
            Character firstLetter;
            while ((s = fileReader.readLine()) != null) {
                firstLetter = Character.toUpperCase(s.charAt(0));
                if (citiesMap.containsKey(firstLetter)){
                    tempSet = citiesMap.get(firstLetter);
                    tempSet.add(s);
                }
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public boolean cityInMap (){

        return false;
    }

    public String getRandomCitiByChar(Character firstLetter){

        return null;
    }

    public Character getNextCityChar(String city){
        return(city.charAt(city.length()-1));
    }

    public void printMap(){
        for (Map.Entry<Character, HashSet<String>> cm : citiesMap.entrySet()) {
            System.out.println(cm.getKey()+ "\t-\t" + cm.getValue());

        }
    }

}
