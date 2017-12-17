package ru.teterkin.blackjack;

/**
 * В нашей игре мы напишем консольный вариант сразу так, чтобы потом его классы можно
 * было использовать для графической игры.
 */
public class Main
{

    public static void main(String[] args)
    {
        Game game = new Game();
        game.sayHello();
        if (game.useText())
        {
            System.out.println(game.getTEXT_CHOSEN());
            game.run();
            System.out.println(game.getBYE_MSG());
        }
        else
        {
            System.out.println(game.getGUI_CHOSEN());
            System.out.println(game.getGUI_NOT_IMPLEMENTED());
        }
    }
}
