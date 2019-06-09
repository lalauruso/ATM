package com.company;

import java.util.Objects;

public class Account
{
    private String name;
    private String password;
    private double balance;

    public Account(String name, String password, double balance)
    {
        this.name = Objects.requireNonNull(name);
        this.password = Objects.requireNonNull(password);
        this.balance = balance;
    }

    public boolean isMatching(String name, String password)
    {
        return Objects.equals(this.name, name) && Objects.equals(this.password, password);
    }
}
