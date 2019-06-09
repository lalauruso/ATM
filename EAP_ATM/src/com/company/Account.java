package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account
{
    private String name;
    private int password;
    private ArrayList<Deposit> depositList = new ArrayList<Deposit>();
    private double totalFunds;

    public Account(String name, int password)
    {
        this.name = Objects.requireNonNull(name);
        this.password = Objects.requireNonNull(password);
    }

    public boolean isMatching(String name, int password)
    {
        return Objects.equals(this.name, name) && Objects.equals(this.password, password);
    }

    public void AddDepositToAccount(Deposit depositToAdd)
    {
        depositList.add(depositToAdd);
    }

    public boolean passwordIsCorect(int passwordToCheck)
    {
        if(passwordToCheck == password)
        {
            return true;
        }

        return false;
    }

    public Deposit getDepositByName(String name)
    {
        for(Deposit deposit : depositList)
        {
            if(deposit.depositExists(name))
            {
                return deposit;
            }
        }

        return null;
    }

    public void addToTotalFunds(double totalFundsToAdd, Deposit depositToCheck)
    {
        if(totalFundsToAdd >= depositToCheck.getBalance())
        {
            totalFunds += depositToCheck.getBalance();
        }
        else
        {
            totalFunds += totalFundsToAdd;
        }
    }

    public void decreaseFromTotalFunds(double totalFundsToDecrease)
    {
        if(totalFundsToDecrease >= totalFunds)
        {
            totalFunds = 0;
        }
        else
        {
            totalFunds -= totalFundsToDecrease;
        }
    }

    public void setTotalFunds(double totalFunds)
    {
        this.totalFunds = totalFunds;
    }

    public double getTotalFunds()
    {
        return totalFunds;
    }

    public String getAccountName()
    {
        return name;
    }

    public boolean accountExists(String name)
    {
        return Objects.equals(this.name, name);
    }

    public ArrayList<Deposit> getDepositList()
    {
        return depositList;
    }
}
