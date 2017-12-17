package ru.teterkin.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private final String NEW_DECK = "\nСоздаём новую деку из 2 колод...";
    private final String DECK_CREATED = "Дека создана. Количество: ";
    private final String SHUFFLE_MSG = "Перемешиваем...";
    private final String READY_MSG = "Готово.";

    private Card[] deck;
    private ArrayList<Card> deckQueue = new ArrayList<Card>();

    /**
     * Создает новую деку из 104 карт. Это 2 стандартные колоды по 52 карты:
     * 4 масти, от 2-ки до Туза.
     * Вне конструктора, т.к. пересоздать новую деку можно в любое время.
     */
    public void newDeck()
    {
        String[] suiteNamesEng = {"clubs", "diamonds", "hearts", "spades"};
        String[] suiteNamesRus = {"Крести", "Буби", "Черви", "Пики"};
        String[] cardNames = {"Туз", "Двойка", "Тройка", "Четверка", "Пятерка",
                              "Шестерка", "Семерка", "Восьмерка", "Девятка",
                              "Десятка", "Валет", "Дама", "Король"};

        System.out.println(NEW_DECK);
        deck = new Card[104];
        int deckPos = 0;
        int tempVal = 0;
        for (int i = 0; i < 2; i++)
        {
            // System.out.println("Колода №" + (i+1) + ":");
            // System.out.println("В каждой колоде по 4 масти:");
            // System.out.println("В кажой масти по 13 карт:");
            int suiteIdx = 0;
            for (String sne : suiteNamesEng)
            {
                // System.out.println(suiteNamesRus[suiteIdx]+":");
                for (int j = 1; j <= 13; j++)
                {
                    // System.out.println(cardNames[j-1]);
                    if (j < 11)
                    {
                        tempVal = j;
                    }
                    else
                    {
                        tempVal = 10;
                    }
                    deck[deckPos] = new Card(tempVal,j,sne);
                    // System.out.println(deck[deckPos]);
                    deckPos++;
                }
                suiteIdx++; // индекс для мастей
            }
        }
        System.out.println(DECK_CREATED + deckPos + ".");
        // display(deck);
        System.out.println(SHUFFLE_MSG);
        shuffle(deck);
        System.out.println(READY_MSG);
        // display(deck);
        enqueue(deck);
    }

    public void shuffle(Card[] deck)
    {
        Random random = new Random();
        for (int i = deck.length - 1 ; i > 0 ; i--)
        {
            int newIdx = random.nextInt(i + 1);
            Card temp = deck[newIdx];
            deck[newIdx] = deck[i];
            deck[i] = temp;
        }
    }

    private void display(Card[] deck)
    {
        for (int i = 0; i < deck.length ; i++)
        {
            System.out.println(deck[i]);
        }
    }

    private void enqueue(Card[] deck)
    {
        for (Card deckCard : deck)
        {
            deckQueue.add(deckCard);
        }
        // System.out.println("Размер очереди: " + deckQueue.size());
    }

    public Card[] getDeck()
    {
        return deck;
    }

    public void setDeck(Card[] deck)
    {
        this.deck = deck;
    }

    public Card getCard()
    {
        Card card = deckQueue.get(0);
        deckQueue.remove(0);
        // System.out.println("Осталось карт: " + deckQueue.size());
        return card;
    }

    public int getDeckCardsNum()
    {
        return deckQueue.size();
    }

}
