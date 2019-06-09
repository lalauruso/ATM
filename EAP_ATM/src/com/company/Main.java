package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String tempUsername;
        int tempPassword;

        AccountManager accountManager = new AccountManager();

        while(true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 for login with an existing account and 2 for registering a new one.");

            switch(in.nextInt())
            {
                case 1:
                {
                    System.out.println("Enter username:");
                    tempUsername = in.nextLine();

                    System.out.println("Enter password:");
                    tempPassword = in.nextInt();

                    accountManager.login(tempUsername, tempPassword);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter username:");
                    tempUsername = in.nextLine();

                    System.out.println("Enter password:");
                    tempPassword = in.nextInt();

                    accountManager.registerAccount(tempUsername, tempPassword);

                    break;
                }
            }
        }
    }
}
