package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String tempUsername = "";
        int tempPassword;
        double totalFunds = 0;

        Account currentAccount;
        Deposit currentDeposit;

        Deposit fromTransferDeposit;
        Deposit toTransferDeposit;

        boolean loginSuccessful = false, issuedLogout = false;

        AccountManager accountManager = new AccountManager();

        ConsoleReader consoleReader = new ConsoleReader(System.in);

        new LoginScreen();

        while (true && !issuedLogout) {
            while (!loginSuccessful) {
                System.out.println("Press 1 for login with an existing account and 2 for registering a new one.");

                switch (consoleReader.readInt()) {
                    case 1: {
                        System.out.println("Enter username:");
                        tempUsername = consoleReader.readLine();

                        System.out.println("Enter password:");
                        tempPassword = consoleReader.readInt();

                        if (accountManager.login(tempUsername, tempPassword)) {
                            loginSuccessful = true;
                        }

                        break;
                    }
                    case 2: {
                        System.out.println("Enter username:");
                        tempUsername = consoleReader.readLine();

                        System.out.println("Enter password:");
                        tempPassword = consoleReader.readInt();

                        if (accountManager.registerAccount(tempUsername, tempPassword)) {
                            System.out.println("Enter total funds:");
                            totalFunds = consoleReader.readDouble();
                            accountManager.getAccountByName(tempUsername).setTotalFunds(totalFunds);
                        }

                        loginSuccessful = true;

                        break;
                    }
                }
            }

            System.out.println("1.Open deposit; 2.Add funds; 3.Withdraw funds; 4.Check account state; 5.Transfer funds; 6.Logout; 7.Exit");

            currentAccount = accountManager.getAccountByName(tempUsername);

            switch (consoleReader.readInt()) {
                case 1: {
                    String tempDepositName;

                    System.out.println("Enter deposit name:");
                    tempDepositName = consoleReader.readLine();

                    currentAccount.AddDepositToAccount(new Deposit(tempDepositName));

                    break;
                }
                case 2: {
                    String tempDepositName;
                    double fundsToAdd = 0;

                    System.out.println("Enter deposit name:");
                    tempDepositName = consoleReader.readLine();

                    currentDeposit = currentAccount.getDepositByName(tempDepositName);

                    if (currentDeposit == null) {
                        System.out.println(tempDepositName + " doesn't exist!");
                    } else {
                        System.out.println("Enter funds to add:");
                        fundsToAdd = consoleReader.readDouble();

                        currentAccount.decreaseFromTotalFunds(fundsToAdd);
                        currentDeposit.addFunds(fundsToAdd);
                    }

                    break;
                }
                case 3: {
                    String tempDepositName;
                    double fundsToWithdraw = 0;

                    System.out.println("Enter deposit name:");
                    tempDepositName = consoleReader.readLine();

                    currentDeposit = currentAccount.getDepositByName(tempDepositName);

                    if (currentDeposit == null) {
                        System.out.println(tempDepositName + " doesn't exist!");
                    } else {
                        System.out.println("Enter funds to withdraw: ");
                        fundsToWithdraw = consoleReader.readDouble();

                        currentAccount.addToTotalFunds(fundsToWithdraw, currentDeposit);
                        currentDeposit.withdrawFunds(fundsToWithdraw);
                    }

                    break;
                }
                case 4: {
                    accountManager.printInformation(currentAccount);
                    break;
                }
                case 5: {
                    String fromTransferDepositName;
                    String toTransferDepositName;

                    double fundToTransfer = 0;

                    System.out.println("Enter name of deposit from which you want to transfer:");
                    fromTransferDepositName = consoleReader.readLine();

                    fromTransferDeposit = currentAccount.getDepositByName(fromTransferDepositName);

                    if (fromTransferDeposit == null) {
                        System.out.println(fromTransferDepositName + " doesn't exist!");
                    } else {
                        System.out.println("Enter name of deposit to which you want to transfer:");
                        toTransferDepositName = consoleReader.readLine();

                        toTransferDeposit = currentAccount.getDepositByName(toTransferDepositName);

                        if (toTransferDeposit == null) {
                            System.out.println(toTransferDepositName + " doesn't exist!");
                        } else {
                            System.out.println("Enter funds to withdraw: ");
                            fundToTransfer = consoleReader.readDouble();

                            fromTransferDeposit.withdrawFunds(fundToTransfer);
                            toTransferDeposit.addFunds(fundToTransfer);
                        }
                    }


                    break;
                }
                case 6: {
                    loginSuccessful = false;
                    break;
                }
                case 7: {
                    issuedLogout = true;
                    break;
                }
            }
        }
    }
}
