package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFundsScreen implements ActionListener
{
    JFrame f;
    JTextField tf1, tf2;
    JButton b1;
    JLabel j1, j2;

    AccountManager accountManager = new AccountManager();
    Account currentAccount;

    AddFundsScreen(AccountManager accountManager, Account currentAccount)
    {
        JFrame f = new JFrame();
        tf1 = new JTextField();
        tf1.setBounds(50, 50, 150, 20);
        j1 = new JLabel("Enter deposit name");
        j1.setBounds(25, 25, 100, 20);
        tf2 = new JTextField();
        tf2.setBounds(50, 150, 150, 20);
        j2 = new JLabel("Enter funds to add");
        j2.setBounds(25, 120, 100, 20);
        b1 = new JButton("Add funds");
        b1.setBounds(50, 200, 100, 50);
        b1.addActionListener(this);
        f.add(tf1);
        f.add(j1);
        f.add(b1);
        f.add(tf2);
        f.add(j2);
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

        String s2 = tf2.getText();

        if(e.getSource() == b1)
        {
            Deposit currentDeposit = currentAccount.getDepositByName(s1);

            if (currentDeposit == null)
            {
                f.setVisible(false);
            }
            else
            {
                currentAccount.decreaseFromTotalFunds(Double.parseDouble(s2));
                currentDeposit.addFunds(Double.parseDouble(s2));
            }

            f.setVisible(false);
        }
    }
}