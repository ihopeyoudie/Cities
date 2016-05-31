package net.dzirt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * Created by Dzirt on 29.05.2016.
 */
public class CitiesGame {
    private MainFrame mainFrame = new MainFrame();
    private CitiesMap map;
    private String compCity;// = null;
    private String playerCity;
    private Character nextCityChar;

    public void gameInit(String filePath){
        map = new CitiesMap();
        File f = new File(filePath);
        map.buildMap(f);
    }
    public void gameStart() throws Exception{
        compCity = null;
//
//        String playerCity;
//        Boolean realCity;
//        Boolean nextCityExist;
//        Character nextCityChar;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mainFrame.initComponents();
        mainFrame.setLabelHelp("Введите название города на букву: ");
        compCity = map.getRandomCityByChar('А');
        mainFrame.setTextFieldComp(compCity);
        mainFrame.addToLog("comp:   "+compCity);
        nextCityChar = map.getNextCityChar(compCity);
//        System.out.println(nextCityChar);
        mainFrame.setLabelNextChar(nextCityChar.toString());
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
        mainFrame.setButtonAL(new ButtonEnterActionListener());
        mainFrame.setTextFieldPlayerKeyListener(new TextFieldPlayerKeyListener());
//        boolean gameFlag = true;
//        while (gameFlag){
//            //System.out.println("Введите название города: ");
//            mainFrame.setLabelHelp("Введите название города");
//            playerCity = reader.readLine().toUpperCase();
//            if (compCity != null){
//                if(playerCity.charAt(0) != map.getNextCityChar(compCity)){
//                    System.out.println("Не соответствует буква, введите еще раз: ");
//                    continue;
//                }
//            }
//            if(!map.cityInMap(playerCity)){
//                System.out.println("Города нет в списке, введите еще раз: ");
//                continue;
//            }
//            map.removeCity(playerCity);
//            nextCityChar = map.getNextCityChar(playerCity);
//            System.out.println("Следующая буква: "+ nextCityChar);
//            if(!map.nextCityExist(nextCityChar)){
//                gameFlag = false;
//                System.out.println("Game over, player wins");
//                continue;
//            }
//            compCity = map.getRandomCityByChar(nextCityChar);
//            System.out.println("Компьютер выбрал город: ");
//            System.out.println(compCity);
//            map.removeCity(compCity);
//            nextCityChar = map.getNextCityChar(compCity);
//            if(!map.nextCityExist(nextCityChar)){
//                gameFlag = false;
//                System.out.println("Game over, computer wins");
//                continue;
//            }
//            System.out.println("Ввеите город на букву "+ nextCityChar);
//        }
    }

    public class ButtonEnterActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameTurn();
        }
    }

    public class TextFieldPlayerKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //System.out.println(e.getKeyChar());
            if(e.getKeyChar()=='\n') {
                gameTurn();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }



    public void gameTurn(){
        playerCity = mainFrame.getPlayerCity().toUpperCase();
        if ((playerCity != null)&&(!playerCity.equals(""))) {
            if ((playerCity.charAt(0) == map.getNextCityChar(compCity))) {
                if (map.cityInMap(playerCity)) {
                    mainFrame.addToLog("player:   "+playerCity);
                    map.removeCity(playerCity);
                    mainFrame.setTextFieldPlayer("");
                    nextCityChar = map.getNextCityChar(playerCity);
                    if (map.nextCityExist(nextCityChar)){
                        compCity = map.getRandomCityByChar(nextCityChar);
                        nextCityChar = map.getNextCityChar(compCity);
                        mainFrame.setTextFieldComp(compCity);
                        mainFrame.addToLog("comp:   "+compCity);
                        if (map.nextCityExist(nextCityChar)){
                            mainFrame.setLabelHelp("Введите город на букву: ");
                            mainFrame.setLabelNextChar(nextCityChar.toString());
                        }else {}//message about player wins

                    }else{}//message about player wins
                }else{mainFrame.setLabelHelp("Города нет в списке, введите еще раз: ");}
            }else{mainFrame.setLabelHelp("Не соответствует буква, введите еще раз: ");}
        }else{mainFrame.setLabelHelp("Введите название города еще раз");}
    }

}
