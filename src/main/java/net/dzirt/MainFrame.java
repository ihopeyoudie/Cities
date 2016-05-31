package net.dzirt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 *
 * Created by Dzirt on 27.05.2016.
 */
public class MainFrame extends JFrame {
    // Variables declaration
    private JButton buttonExit;
    private JButton buttonEnter;
    private JLabel labelHelp = new JLabel("Ввеите название города");
    private JLabel labelNextChar;
    //private JScrollPane jScrollPane1;
    private JTextField textFieldPlayer;
    private JTextField textFieldComp;
    private JTextArea textPaneGameLog;

        // End of variables declaration
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {

    }



    public void initComponents() {
        /**
         * Init Frame
        */
        setTitle("GAME");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600,400);
        setSize(400,400);
        setResizable(false);
        setLayout(new GridBagLayout());


        textFieldComp = new JTextField();
        textFieldComp.setEnabled(false);
        textFieldComp.setDisabledTextColor(Color.BLACK);


        add(textFieldComp, new GridBagConstraints(0,0,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),200,0));

        textFieldPlayer = new JTextField();
        add(textFieldPlayer, new GridBagConstraints(0,2,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        add(labelHelp, new GridBagConstraints(0,1,2,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),200,0));

        labelNextChar = new JLabel("");
        add(labelNextChar, new GridBagConstraints(2,1,1,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),40,40));

        buttonEnter = new JButton("ENTER");
        add(buttonEnter, new GridBagConstraints(0,3,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        textPaneGameLog = new JTextArea();
        JScrollPane scroll = new JScrollPane (textPaneGameLog);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scroll);
        textPaneGameLog.setLineWrap(true);
        textPaneGameLog.setEnabled(false);
        textPaneGameLog.setDisabledTextColor(Color.BLACK);
        scroll.setAutoscrolls(true);
        add(scroll, new GridBagConstraints(3,0,3,5,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),150,300));
        //textPaneGameLog.append("1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n21\n1\n1\n");
        setVisible(true);
        pack();
    }
    public void setLabelHelp(String s){
        labelHelp.setText(s);
    }
    public void setLabelNextChar(String s){
        labelNextChar.setText(s);
    }

    public String getPlayerCity(){
        return textFieldPlayer.getText();
    }
    public void setTextFieldComp(String s){
        textFieldComp.setText(s);
    }
    public void setTextFieldPlayer(String s) {
        textFieldPlayer.setText(s);
    }
    public void addToLog(String s){
        textPaneGameLog.append(s+ "\n");
    }
    public void setButtonAL (ActionListener a){
        buttonEnter.addActionListener(a);
    }

    public void setTextFieldPlayerKeyListener(KeyListener a){
        textFieldPlayer.addKeyListener(a);
    }

}
