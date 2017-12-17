package ru.teterkin.blackjack;

import javax.swing.*;
import java.util.Arrays;

/**
 * Универсальный класс. Используется как для игрока, так и для компьютера.
 * Держит карты игрока или компьютера.
 */
public class Hand
{
    private Card[] cards;
    private int cardIdx;

    public Hand()
    {
        cards = new Card[21];
        cardIdx = 0;
    }

    public void addCard(Card card)
    {
        cards[cardIdx] = card;
        cardIdx++;
    }

    public ImageIcon getCardIcon()
    {
        return cards[cardIdx - 1].getImage();
    }

    public int getTotalScore()
    {
        int score = 0;
        for (int i = 0; i < cardIdx ; i++)
        {
            score += cards[i].getValue();
        }
        return score;
    }

    public int getCardNumber()
    {
        return cardIdx;
    }

    @Override
    public String toString()
    {
        String RS = "В руке { \n" +
                "Карты = \n";
        for (int i = 0; i < cardIdx; i++)
        {
            RS += "\t" + cards[i] + "\n";
        }
        RS += ", количество = " + cardIdx + " }";
        return  RS;
    }
}
