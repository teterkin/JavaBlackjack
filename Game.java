package ru.teterkin.blackjack;

import java.util.Scanner;

/**
 * Главный класс. Все информация по игре находится здесь.
 * Как для консольного варианта, так и для графики.
 */
public class Game
{
    private final String HELLO_MSG = "\n* * * Добро пожаловать в игру Blackjack! * * *\n";
    private final String TEXT_OR_GUI_MSG = "Выберите режим! 0 - Текст. 1 - Графика.";
    private final String RULES_MSG = "Мы вам выдаем виртуальные $500. Ставка в игре от $5 до $500.\n" +
            "Можете покинуть игру, когда захотите или мы вас попросим,\n" +
            "когда у вас кончатся деньги. :(\n" +
            "\n" +
            "Вам нужно набрать 21 очко или меньше, но больше чем у Сдающего.\n" +
            "Карты \"10\", \"J\", \"Q\", \"K\" дают 10 очков.\n" +
            "Туз \"A\" даёт 1 очко или 11, как вам выгодней.\n" +
            "\"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\" столько и дают. :)";
    private final String IOERR_MSG = "Ошибочка вышла. Попробуй ещё!";
    private final String TEXT_CHOSEN = "Вы выбрали игру в консоли. Хороший выбор.";
    private final String GUI_CHOSEN = "Вы быбрали графику.";
    private final String GUI_NOT_IMPLEMENTED = "Но графики пока нет... :(";
    private final String BYE_MSG = "Спасибо за игру! До встречи.";
    private final String YOU_HAVE_MSG = "У вас в наличии $ ";
    private final String NEW_GAME_MSG = "Начинаем игру: ";
    private final String BAD_CHOICE_MSG = "Не правильный выбор!";

    private Scanner sc = new Scanner(System.in);

    private short money = 500;
    private boolean playing = true;

    public String getBYE_MSG()
    {
        return BYE_MSG;
    }

    public String getTEXT_CHOSEN()
    {
        return TEXT_CHOSEN;
    }

    public String getGUI_CHOSEN()
    {
        return GUI_CHOSEN;
    }

    public String getRULES_MSG()
    {
        return RULES_MSG;
    }

    public short getMoney()
    {
        return money;
    }

    public void setMoney(short money)
    {
        this.money = money;
    }

    public void sayHello()
    {
        System.out.println(HELLO_MSG);
    }

    public String getGUI_NOT_IMPLEMENTED()
    {
        return GUI_NOT_IMPLEMENTED;
    }

    /**
     * Метод запрашивает вариант игры
     * 0 - текустовый, 1 - графический
     * Метод использует обработку прерываний, чтобы исключить
     * вывод ошибки при вводе не корректнных значений. В таким случаях
     * предлагается снова сделать выбор.
     * @return логическое ИСТИНА, если выбран текстовый режим
     * или логическое ЛОЖЬ, если выбран графический режим.
     */
    public boolean useText()
    {
        boolean keepAsking = true;
        boolean useText = true;

        while (keepAsking)
        {
            int num = -1;
            System.out.println(TEXT_OR_GUI_MSG);
            try
            {
                num = sc.nextInt();
            }
            catch (Exception e)
            {
                System.out.println(IOERR_MSG);
                sc.next(); // Раз ошиблись,идём дальше.
            }
            if (num == 1)
            {
                useText = false;
                keepAsking = false;
            }
            else if (num == 0)
            {
                useText = true;
                keepAsking = false;
            }
            else
            {
                System.out.println(BAD_CHOICE_MSG);
            }
        }

        return useText;
    }

    /**
     * Главный цикл игры
     * Работает пока переменная playing возвращает ИСТИНА.
     */
    public void run()
    {
        Deck deck = new Deck();
        deck.newDeck();
        Hand dealer = new Hand();
        Hand player = new Hand();

        // TODO: Попозже можно добавить игроков типа compPlayer[0], compPlayer[1] и т.п.

        while (playing)
        {
            System.out.println();
            System.out.println(NEW_GAME_MSG);
            System.out.println(YOU_HAVE_MSG + getMoney());

            // Card newCard = deck.getCard();
            // System.out.println(newCard);

            // Выдача карты Раздающему
            System.out.println("Дилер берет одну карту себе...");
            dealer.addCard(deck.getCard());
            System.out.println(dealer);

            // Выдача 2-х карт Игроку
            System.out.println("Дилер выдает 2 карты игроку...");
            player.addCard(deck.getCard());
            player.addCard(deck.getCard());
            System.out.println(player);
            System.out.println("Осталось в деке: " + deck.getDeckCardsNum() + " карт.");

            // Обработка выигрыша Игрока на раздаче

            // Запрос хочет ли Игрок еще карту
                // Выдача карты, при необходимости
                // Проверка на Выигрыш или Перебор
            // Раздача карт диллеру пока он не наберет боьше 17 (простой интеллект)
            // Проверка 21,
            // перебора,
            // ничьи,
            // выигрыша,
            // или проигрыша.
            // Проверка хотим ли ещё.
            playing = false; // TODO: Заменить потом на нормальный выход из игры.
        }
    }
}
