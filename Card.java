package ru.teterkin.blackjack;

import javax.swing.*;

public class Card
{
    private int value;
    private int type;
    private String suite;
    private ImageIcon image;

    public Card(int value, int type, String suite)
    {
        this.value = value;
        this.type = type;
        this.suite = suite;
        String imagePath = "images/" + type + suite + ".png";
        ImageIcon image = new ImageIcon(getClass().getResource(imagePath));
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "Card{" +
                "value=" + value +
                ", type=" + type +
                ", suite='" + suite + '\'' +
                ", image=" + image +
                '}';
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getSuite()
    {
        return suite;
    }

    public void setSuite(String suite)
    {
        this.suite = suite;
    }

    public ImageIcon getImage()
    {
        return image;
    }

    public void setImage(ImageIcon image)
    {
        this.image = image;
    }
}
