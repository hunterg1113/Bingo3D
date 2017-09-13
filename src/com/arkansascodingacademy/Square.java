package com.arkansascodingacademy;

public class Square
{
    private int number;
    private boolean covered;

    public Square(int number)
    {
        this.number = number;
        covered = false;
    }

    public void cover()
    {
        covered = true;
    }

    public boolean isCovered()
    {
        return covered;
    }

    public int getNumber()
    {
        return number;
    }

    public void print()
    {
        if (covered)
        {
            System.out.print("XXX");
        }
        else
        {
            if (number < 10)
            {
                System.out.print("00" + number);
            }
            else if (number < 100)
            {
                System.out.print("0" + number);
            }
            else
            {
                System.out.print(number);
            }
        }
    }
}