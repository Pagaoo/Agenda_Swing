package ui;

import javax.swing.*;

public class MainForm extends JFrame {
    private JButton novoContatoButton;
    private JButton excluirContatoButton;
    private JTable contactTable;
    private JPanel rootPanel;

    public MainForm(){
        setContentPane(rootPanel);
        setVisible(true);
        setSize(500,250);
    }
}
