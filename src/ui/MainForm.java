package ui;

import business.contactBusiness;
import entity.contactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton novoContatoButton;
    private JButton excluirContatoButton;
    private JTable contactTable;
    private JPanel rootPanel;
    private JLabel countContactLabel;

    private contactBusiness mContactBusiness;
    private String mName = "";
    private String mPhone = "";

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

    private void loadContacts() {
        java.util.List<contactEntity> contactList = mContactBusiness.getContactList();

        String[] columnNames = {"Nome", "Telefone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames); //cria um objeto vazio com base nos nomes das colunas

        for(contactEntity c: contactList) {
            Object[] o = new Object[2]; //Fala que a fonte de dados tem duas fontes: Nome e telefone

            o[0] = c.getName();
            o[1] = c.getPhone();

            model.addRow(o);
        }
        contactTable.clearSelection();//Tira o clique da listagem
        contactTable.setModel(model);

        countContactLabel.setText(mContactBusiness.getContactCount());
    }

    private void setListeners(){
        novoContatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();// esconde o main form
            }
        });

        contactTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    if (contactTable.getSelectedRow() != -1) {
                        mName = contactTable.getValueAt(contactTable.getSelectedRow(), 0).toString();//coluna 0 = name
                        mPhone = contactTable.getValueAt(contactTable.getSelectedRow(), 1).toString();//coluna 1 = phone
                    }
                }
            }
        });

        excluirContatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mContactBusiness.deleteContact(mName, mPhone);
                    loadContacts();

                    mName = ""; //depois de remover precisa limpar a var
                    mPhone = ""; //depois de remover precisa limpar a var
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            }
        });
    }
}
