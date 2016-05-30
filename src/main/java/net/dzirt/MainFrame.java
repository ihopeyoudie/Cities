package net.dzirt;

import javax.swing.*;
import java.awt.*;

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
    private JPanel panel1;
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
        //buttonExit = new JButton("Exit");
        textFieldComp = new JTextField();
        textFieldComp.setEnabled(false);
        textFieldComp.setDisabledTextColor(Color.BLACK);
        //textFieldComp.setText("Testing");
        add(textFieldComp, new GridBagConstraints(0,0,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),200,0));

        textFieldPlayer = new JTextField();
        add(textFieldPlayer, new GridBagConstraints(0,2,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        add(labelHelp, new GridBagConstraints(0,1,2,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        labelNextChar = new JLabel("");
        add(labelNextChar, new GridBagConstraints(2,1,1,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        buttonEnter = new JButton("ENTER");
        add(buttonEnter, new GridBagConstraints(0,3,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        textPaneGameLog = new JTextArea();
        textPaneGameLog.setEnabled(false);
        textPaneGameLog.setDisabledTextColor(Color.BLACK);

        add(textPaneGameLog, new GridBagConstraints(3,0,3,5,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),150,300));

        setVisible(true);
        pack();
    }
    public void setLabelHelp(String s){
        labelHelp.setText(s);
    }
}
