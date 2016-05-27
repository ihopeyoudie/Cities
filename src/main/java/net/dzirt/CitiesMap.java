package net.dzirt;

import java.io.*;
import java.util.*;

/**
 * Created by Dzirt on 27.05.2016.
 */
public class CitiesMap {

    private Map<Character,HashSet<String>>  citiesMap = new HashMap<>();
    public void buildMap(File file){

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

}
