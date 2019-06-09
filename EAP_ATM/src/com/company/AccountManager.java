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
}
