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
                    tempSet.add(s.toUpperCase());
                }
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public boolean cityInMap (String city){

        HashSet<String> cts;
        city = city.toUpperCase();
        Character firstLetter = city.charAt(0);
        cts = citiesMap.get(firstLetter);
        if (cts.size()>0) {
            if (cts.contains(city.toUpperCase())) return true;
        }
        return false;
    }
    public boolean nextCityExist (Character nextCityLetter){
        HashSet<String> cts;
        cts = citiesMap.get(nextCityLetter);
        if (cts.size()>0) {
            return true;
        }
        return false;
    }



    public String getRandomCityByChar(Character firstLetter){
        try {
            HashSet<String> cts;
            cts = citiesMap.get(firstLetter);
            if (cts.size()>0) {
                String[] stArray = cts.toArray(new String[cts.size()]);

                int itemIndex = (int) (Math.random() * stArray.length);

                //System.out.println(firstLetter+ " - " + stArray.length+ " :" +itemIndex );
                String city = stArray[itemIndex];
                //cts.remove(city);
                return stArray[itemIndex];
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean removeCity(String city){
        try {
            HashSet<String> cts;
            cts = citiesMap.get(city.charAt(0));
            if (cts.size()>0) {
                 cts.remove(city);
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public Character getNextCityChar(String city){
        city = city.toUpperCase();
        return(city.charAt(city.length()-1));
    }

    public void printMap(){
        for (Map.Entry<Character, HashSet<String>> cm : citiesMap.entrySet()) {
            System.out.println(cm.getKey()+ "\t-\t" + cm.getValue());

        }
    }

}
