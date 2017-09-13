package com.arkansascodingacademy;

public class CardBox
{
    private Square square[][][] = new Square[5][5][5];


    public CardBox()
    {
        int x = 1;
        int y = 15;

        for (int depth = 0; depth < 5; depth++)
        {
            for (int column = 0; column < 5; column++)
            {
                Numbers numbers = new Numbers(x, y);

                for (int row = 0; row < 5; row++)
                {
                    square[row][column][depth] = new Square(numbers.drawNumber());
                }

                x += 15;
                y += 15;
            }
        }
    }

    public void play(int number)
    {
        for (int depth = 0; depth < 5; depth++)
        {
            for (int row = 0; row < 5; row++)
            {
                for (int column = 0; column < 5; column++)
                {
                    if (number == square[row][column][depth].getNumber())
                    {
                        square[row][column][depth].cover();
                    }
                }
            }
        }
    }

    public boolean bingo()
    {
        return bingoByVerticalSlice() || bingoByHorizontalSlice() || bingoByDepthSlice() || bingoByCrossSlice();
    }

    public boolean bingoByDepthSlice()
    {
        boolean bingo = false;

        for (int depth = 0; depth < 5; depth++)
        {
            int x = 0;

            for (int column = 0; column < 5; column++)
            {
                for (int row = 0; row < 5; row++)
                {
                    if (square[row][column][depth].isCovered())
                    {
                        x++;
                    }
                }

            }

            if (x == 25)
            {
                System.out.println("Bingo by DepthSlice");
                bingo = true;
            }
        }
        return bingo;
    }

    public boolean bingoByHorizontalSlice()
    {
        boolean bingo = false;

        for (int row = 0; row < 5; row++)
        {
            int x = 0;

            for (int depth = 0; depth < 5; depth++)
            {
                for (int column = 0; column < 5; column++)
                {
                    if (square[row][column][depth].isCovered())
                    {
                        x++;
                    }
                }

            }

            if (x == 25)
            {
                System.out.println("Bingo by Horizontal Slice");
                bingo = true;
            }
        }
        return bingo;
    }

    public boolean bingoByVerticalSlice()
    {
        boolean bingo = false;

        for (int column = 0; column < 5; column++)
        {
            int x = 0;

            for (int depth = 0; depth < 5; depth++)
            {
                for (int row = 0; row < 5; row++)
                {
                    if (square[row][column][depth].isCovered())
                    {
                        x++;
                    }
                }

            }

            if (x == 25)
            {
                System.out.println("Bingo by Vertical Slice");
                bingo = true;
            }
        }
        return bingo;
    }

    public boolean bingoByCrossSlice()
    {
        return bingoByCrosscut1() || bingoByCrosscut2() || bingoByCrosscut3() ||
                bingoByCrosscut4() ||bingoByCrosscut5() ||bingoByCrosscut6();
    }

    public boolean bingoByCrosscut1()
    {
        boolean bingo = false;

        int row = 0;
        int x = 0;

        for (int column = 0; column < 5; column++, row++)
        {
            for (int depth = 0; depth < 5; depth++)
            {
                if (square[row][column][depth].isCovered())
                {
                    x++;
                }

            }
        }

        if (x == 25)
        {
            System.out.println("Bingo by Crosscut1");
            bingo = true;
        }

        return bingo;
    }

    public boolean bingoByCrosscut2()
    {
        boolean bingo = false;

        int row = 4;
        int x = 0;

        for (int column = 0; column < 5; column++, row--)
        {
            for (int depth = 0; depth < 5; depth++)
            {
                if (square[row][column][depth].isCovered())
                {
                    x++;
                }

            }
        }

        if (x == 25)
        {
            System.out.println("Bingo by Crosscut2");
            bingo = true;
        }

        return bingo;
    }

    public boolean bingoByCrosscut3()
    {
        boolean bingo = false;

        int depth = 0;
        int x = 0;

        for (int row = 0; row < 5; row++, depth++)
        {
            for (int column = 0; column < 5; column++)
            {
                if (square[row][column][depth].isCovered())
                {
                    x++;
                }

            }
        }

        if (x == 25)
        {
            System.out.println("Bingo by Crosscut3");
            bingo = true;
        }

        return bingo;
    }

    public boolean bingoByCrosscut4()
    {
        boolean bingo = false;

        int depth = 4;
        int x = 0;

        for (int row = 0; row < 5; row++, depth--)
        {
            for (int column = 0; column < 5; column++)
            {
                if (square[row][column][depth].isCovered())
                {
                    x++;
                }

            }
        }

        if (x == 25)
        {
            System.out.println("Bingo by Crosscut4");
            bingo = true;
        }

        return bingo;
    }

    public boolean bingoByCrosscut5()
    {
        boolean bingo = false;

        int depth = 0;
        int x = 0;

        for (int column = 0; column < 5; column++, depth++)
        {
            for (int row = 0; row < 5; row++)
            {
                if (square[row][column][depth].isCovered())
                {
                    x++;
                }

            }
        }

        if (x == 25)
        {
            System.out.println("Bingo by Crosscut5");
            bingo = true;
        }

        return bingo;
    }

    public boolean bingoByCrosscut6()
    {
        boolean bingo = false;

        int depth = 4;
        int x = 0;

        for (int column = 0; column < 5; column++, depth--)
        {
            for (int row = 0; row < 5; row++)
            {
                if (square[row][column][depth].isCovered())
                {
                    x++;
                }

            }
        }

        if (x == 25)
        {
            System.out.println("Bingo by Crosscut6");
            bingo = true;
        }

        return bingo;
    }

    public void print()
    {
        for (int depth = 0; depth < 5; depth++)
        {
            for (int row = 0; row < 5; row++)
            {
                for (int column = 0; column < 5; column++)
                {
                    square[row][column][depth].print();
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}











/*

    public boolean bingoByDiagonal()
    {
        boolean bingo = false;

        if (square[0][0].isCovered() && square[1][1].isCovered() && square[2][2].isCovered() &&
                square[3][3].isCovered() && square[4][4].isCovered())
        {
            bingo = true;
        }

        if (square[4][0].isCovered() && square[3][1].isCovered() && square[2][2].isCovered() &&
                square[1][3].isCovered() && square[0][4].isCovered())
        {
            bingo = true;
        }

        return bingo;
    }

    public boolean bingoByStamp()
    {
        boolean bingo = false;

        for (int column = 0; column < 4; column++)
        {
            for (int row = 0; row < 4; row++)
            {
                if (square[row][column].isCovered() &&
                        square[row + 1][column].isCovered() &&
                        square[row][column + 1].isCovered() &&
                        square[row + 1][column + 1].isCovered())
                {
                    bingo = true;
                }
            }
        }
        return bingo;
    }

*/