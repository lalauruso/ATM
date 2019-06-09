package com.company;

public class Deposit
{
    private String name;
    private double balance;

    public Deposit(String depositName, double depositBalance)
    {
        name = depositName;
        balance = depositBalance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String nameToSet)
    {
        name = nameToSet;
    }

    public double getBalance()
    {
        return balance;
    }

    public void addBalance(double balanceToAdd)
    {
        balance += balanceToAdd;
    }
}
