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
    private JLabel label1 = new JLabel("Следующая буква");
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600,400);
        setSize(400,400);

        setResizable(false);
        setLayout(new GridBagLayout());
        //buttonExit = new JButton("Exit");
        textFieldComp = new JTextField();
        textFieldComp.enableInputMethods(false);
        add(textFieldComp, new GridBagConstraints(0,0,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),10,10));

        textFieldPlayer = new JTextField();
        add(textFieldPlayer, new GridBagConstraints(0,2,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),10,10));

        add(label1, new GridBagConstraints(0,1,2,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),10,10));

        labelNextChar = new JLabel("B");
        add(labelNextChar, new GridBagConstraints(2,1,1,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),10,10));

        buttonEnter = new JButton("ENTER");
        add(buttonEnter, new GridBagConstraints(0,3,3,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),10,10));

        textPaneGameLog = new JTextArea();
        add(textPaneGameLog, new GridBagConstraints(3,0,3,5,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                new Insets(1,1,1,1),100,100));

        textPaneGameLog.append("aff\n");
        textPaneGameLog.append("aff");
        textPaneGameLog.append("aff");
        setVisible(true);
        //pack();
    }


}
