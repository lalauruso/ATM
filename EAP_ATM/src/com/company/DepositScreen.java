package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositScreen implements ActionListener
{
    JFrame f;
    JTextField tf1;
    JButton b1;
    JLabel j1;

    AccountManager accountManager = new AccountManager();
    Account currentAccount;

    DepositScreen(AccountManager accountManager, Account currentAccount)
    {
        JFrame f = new JFrame();
        tf1 = new JTextField();
        tf1.setBounds(50, 50, 150, 20);
        j1 = new JLabel("Enter deposit name");
        j1.setBounds(25, 25, 100, 20);
        b1 = new JButton("Add deposit");
        b1.setBounds(50, 100, 100, 50);
        b1.addActionListener(this);
        f.add(tf1);
        f.add(j1);
        f.add(b1);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);

        this.accountManager = accountManager;
        this.currentAccount = currentAccount;

        this.f = f;
    }

    public void actionPerformed(ActionEvent e)
    {
        String s1 = tf1.getText();

        if(e.getSource() == b1)
        {
            currentAccount.AddDepositToAccount(new Deposit(s1));
            f.setVisible(false);
        }
    }
}