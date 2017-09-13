

package com.arkansascodingacademy;


public class Game
{
    private Numbers numbers = new Numbers(1, 375);
    private CardBox card = new CardBox();

    public Game()
    {
    }

    public void play()
    {
        boolean bingo = false;

        while (!bingo)
        {
            int number = numbers.drawNumber();

            card.play(number);
            card.print();
            System.out.println();

            if (card.bingo())
            {
                bingo = true;
            }
        }
    }
}
