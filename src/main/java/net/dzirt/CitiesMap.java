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

    public boolean cityInMap(String city){
//        try {
            HashSet<String> cts;
            city = city.toUpperCase();
            Character firstLetter = city.charAt(0);
            if (citiesMap.containsKey(firstLetter)) {
                cts = citiesMap.get(firstLetter);
                if (cts.size() > 0) {
                    if (cts.contains(city.toUpperCase())) return true;
                }
            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace(System.out);
//        }
        return false;
    }
    public boolean nextCityExist (Character nextCityLetter){
        HashSet<String> cts;
        cts = citiesMap.get(nextCityLetter);
        return cts.size() > 0;
    }

    public String getRandomCityByChar(Character firstLetter){
        try {
            HashSet<String> cts;
            cts = citiesMap.get(firstLetter);
            if (cts.size()>0) {
                String[] stArray = cts.toArray(new String[cts.size()]);
                int itemIndex = (int) (Math.random() * stArray.length);
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
        if (city != null) {
            city = city.toUpperCase();
            Character lastChar;
            lastChar = city.charAt(city.length() - 1);
            if ((lastChar == 'Ь') || (lastChar == 'Й')) {
                lastChar = city.charAt(city.length() - 2);
            }
            return lastChar;
        }
        return '0';
    }

    public void printMap(){
        for (Map.Entry<Character, HashSet<String>> cm : citiesMap.entrySet()) {
            System.out.println(cm.getKey()+ "\t-\t" + cm.getValue());

        }
    }

}
