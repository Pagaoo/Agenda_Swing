package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JTextField textName;
    private JTextField textPhone;
    private JButton salvarButton;
    private JButton cancelarButton;

    public ContactForm(){
        setContentPane(rootPanel);
        setVisible(true);
        setSize(500,250);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // Pega o tamanho da tela do monitor
        setLocation(d.width/2 - getSize().width/2, d.height/2 - getSize().height/2); //Coloca a janela da agenda no meio da sua tela

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fala que quando a janela fechar, o programa para

        setListeners();
    }

    private void setListeners(){
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();// esconde o contact form
            }
        });
    }
}
