package net.dzirt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dzirt on 27.05.2016.
 */
public class MainFrame extends JFrame{
    public MainFrame(String title){
        setTitle(title);
    }
    public void init(){
        setLocation(600,300);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        setVisible(true);

    }
}
