package com.company;

import java.util.List;

public class AccountManager
{
    private List<Account> accounts;

    public List<Account> getAccounts()
    {
        //Test list for now, replace with db list
        accounts.add(new Account("acc1", "12345", 1000));
        accounts.add(new Account("acc2", "12345", 5000));
        accounts.add(new Account("acc3", "12345", 8000));

        return accounts;
    }

    public Account getAccount(String accountName, String password)
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

    public void addAccount(String accountName, String password, double balance)
    {
        if(accountExists(accountName))
        {
            //Show error message
            return;
        }

        accounts.add(new Account(accountName, password, balance));
        //add account to database too
    }
}
