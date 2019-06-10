package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionScreen implements ActionListener
{
    JButton b1, b2, b3, b4, b5, b6, b7;

    AccountManager accountManager = new AccountManager();

    Account currentAccount;

    ActionScreen(AccountManager accountManager, Account currentAccount)
    {
        JFrame f = new JFrame();
        b1 = new JButton("Open deposit");
        b1.setBounds(200, 25, 100, 75);
        b2 = new JButton("Add funds");
        b2.setBounds(200, 125, 100, 50);
        b3 = new JButton("Withdraw funds");
        b3.setBounds(200, 225, 100, 50);
        b4 = new JButton("Check account balance");
        b4.setBounds(200, 325, 100, 50);
        b5 = new JButton("Transfer between deposits");
        b5.setBounds(200, 425, 100, 50);
        b6 = new JButton("Logout");
        b6.setBounds(200, 525, 100, 50);
        b7 = new JButton("Exit");
        b7.setBounds(200, 600, 100, 50);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.setSize(650, 650);
        f.setLayout(null);
        f.setVisible(true);

        this.accountManager = accountManager;
        this.currentAccount = currentAccount;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b1) new DepositScreen(accountManager, currentAccount);
        if (e.getSource() == b2) new AddFundsScreen(accountManager, currentAccount);
        if (e.getSource() == b4) new CheckAccountScreen(accountManager, currentAccount);
    }
}