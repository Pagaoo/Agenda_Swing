package ui;

import javax.swing.*;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JTextField textName;
    private JTextField textPhone;
    private JButton salvarButton;
    private JButton calcelarButton;

    public ContactForm(){
        setContentPane(rootPanel);
        setVisible(true);
        setSize(500,250);
    }
}
