package ui;

import business.contactBusiness;
import entity.contactEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JButton novoContatoButton;
    private JButton excluirContatoButton;
    private JTable contactTable;
    private JPanel rootPanel;

    private contactBusiness mContactBusiness;

    public MainForm(){
        setContentPane(rootPanel);
        setVisible(true);
        setSize(500,250);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // Pega o tamanho da tela do monitor
        setLocation(d.width/2 - getSize().width/2, d.height/2 - getSize().height/2); //Coloca a janela da agenda no meio da sua tela

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fala que quando a janela fechar, o programa para

        mContactBusiness = new contactBusiness();

        setListeners();// Metodo para atribuir eventos
        loadContacts();
    }

    private void setListeners(){
        novoContatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();// esconde o main form
            }
        });

        excluirContatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void loadContacts() {
       java.util.List<contactEntity> contactList = mContactBusiness.getContactList();
    }
}
