package com.company;

import java.util.Objects;

public class Deposit
{
    private String name;
    private double funds;

    public Deposit(String depositName)
    {
        name = depositName;
        funds = 0;
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
        return funds;
    }

    public void addFunds(double balanceToAdd)
    {
        funds += balanceToAdd;
    }

    public void withdrawFunds(double fundsToDecrease)
    {
        if(fundsToDecrease >= funds)
        {
            funds = 0;
            return;
        }

        funds -= fundsToDecrease;
    }

    public boolean depositExists(String name)
    {
        return Objects.equals(this.name, name);
    }
}
