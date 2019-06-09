package com.company;

import java.util.List;
import java.util.Objects;

public class Account
{
    private String name;
    private int password;
    public List<Deposit> depositList;

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

    public boolean accountExists(String name)
    {
        return Objects.equals(this.name, name);
    }
}
