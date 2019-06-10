package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckAccountScreen implements ActionListener
{
    JLabel j1, j2, j3;

    AccountManager accountManager = new AccountManager();

    Account currentAccount;

    CheckAccountScreen(AccountManager accountManager, Account currentAccount)
    {
        JFrame f = new JFrame();
        j1 = new JLabel("Account name: " + currentAccount.getAccountName());
        j1.setBounds(200, 25, 100, 75);
        if(currentAccount.getDepositList().size() != 0)
        {
            j2 = new JLabel("First deposit name: " + currentAccount.getDepositList().get(0).getName());
            j2.setBounds(200, 125, 100, 50);
            j3 = new JLabel("First deposit funds: " + currentAccount.getDepositList().get(0).getBalance());
            j3.setBounds(200, 225, 100, 50);
        }

        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.setSize(650, 650);
        f.setLayout(null);
        f.setVisible(true);

        this.accountManager = accountManager;
        this.currentAccount = currentAccount;
    }

    public void actionPerformed(ActionEvent e)
    {

    }
}