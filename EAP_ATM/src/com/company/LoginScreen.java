package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen implements ActionListener
{
    JFrame f;
    JTextField tf1, tf2;
    JButton b1, b2;
    JLabel j1, j2;

    AccountManager accountManager = new AccountManager();

    Account currentAccount;

    LoginScreen()
    {
        JFrame f = new JFrame();
        tf1 = new JTextField();
        tf1.setBounds(50, 50, 150, 20);
        j1 = new JLabel("Enter username");
        j1.setBounds(25, 25, 100, 20);
        tf2 = new JTextField();
        tf2.setBounds(50, 100, 150, 20);
        j2 = new JLabel("Eneter password");
        j2.setBounds(25, 75, 100, 20);
        b1 = new JButton("Login");
        b1.setBounds(25, 200, 100, 50);
        b2 = new JButton("Register");
        b2.setBounds(145, 200, 100, 50);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.add(tf1);
        f.add(tf2);
        f.add(j1);
        f.add(j2);
        f.add(b1);
        f.add(b2);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        this.f = f;
    }

    public void actionPerformed(ActionEvent e)
    {
        String s1 = tf1.getText();
        String s2 = tf2.getText();

        if (e.getSource() == b1)
        {
            if(accountManager.login(s1, Integer.parseInt(s2)))
            {
                currentAccount = accountManager.getAccountByName(s1);
                new ActionScreen(accountManager, currentAccount);
                f.setVisible(false);
            }
            else
            {

            }
        }
        else if (e.getSource() == b2)
        {
            if(accountManager.registerAccount(s1, Integer.parseInt(s2)))
            {
                currentAccount = accountManager.getAccountByName(s1);
                new ActionScreen(accountManager, currentAccount);
                f.setVisible(false);
            }
            else
            {

            }
        }
    }
}