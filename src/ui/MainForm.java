package ui;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JButton novoContatoButton;
    private JButton excluirContatoButton;
    private JTable contactTable;
    private JPanel rootPanel;

    public MainForm(){
        setContentPane(rootPanel);
        setVisible(true);
        setSize(500,250);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // Pega o tamanho da tela do monitor
        setLocation(d.width/2 - getSize().width/2, d.height/2 - getSize().height/2); //Coloca a janela da agenda no meio da sua tela

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fala que quando a janela fecha, o programa para
    }
}
