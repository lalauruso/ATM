package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AccountManager
{
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public ArrayList<Account> getAccounts()
    {
        System.out.println("There are " + accounts.size() + " in list");

        return accounts;
    }

    public Account getAccount(String accountName, int password)
    {
        for (Account account : accounts)
        {
            if (account.isMatching(accountName, password))
            {
                return account;
            }
        }
        return null;
    }

    private boolean accountExists(String name)
    {
        for (Account account : accounts)
        {
            if (account.accountExists(name))
            {
                return true;
            }
        }

        return false;
    }

    private boolean passwordIsCorrect(String name, int password)
    {
        for (Account account : accounts)
        {
            if (account.accountExists(name))
            {
                if(account.passwordIsCorect(password))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public Account getAccountByName(String name)
    {
        for(Account account : accounts)
        {
            if(account.accountExists(name))
            {
                return account;
            }
        }

        return null;
    }

    public boolean registerAccount(String accountName, int password)
    {
        if(accountExists(accountName))
        {
            System.out.println("Registering an account which already exists!");
            return false;
        }

        accounts.add(new Account(accountName, password));

        return true;
        //add account to database too
    }

    public boolean login(String accountName, int password)
    {
        if(accountExists(accountName))
        {
            if(passwordIsCorrect(accountName, password))
            {
                System.out.println("Logging in with name:" + accountName);

                return true;
            }
        }

        System.out.println("Account doesn't exist!");
        return false;
    }

    public void printInformation(Account account)
    {
        System.out.println("Account name: " + account.getAccountName());
        System.out.println("Total funds: " + account.getTotalFunds());

        for(Deposit deposit : account.getDepositList())
        {
            System.out.println("Deposit name: " + deposit.getName() + " Balance: " + deposit.getBalance());
        }
    }
}
