package com.company;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConsoleReader
{
public ConsoleReader(InputStream inStream)
{
    reader = new BufferedReader(new InputStreamReader(inStream));
}

    public int readInt()
    {
        String inputString = readLine();
        int n = Integer.parseInt(inputString);
        return n;
    }

    public double readDouble()
    {
        String inputString = readLine();
        double x = Double.parseDouble(inputString);
        return x;
    }

    public String readLine()
    {
        String inputLine = "";

        try
        {
            inputLine = reader.readLine();
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }

        return inputLine;
    }

    private BufferedReader reader;
}