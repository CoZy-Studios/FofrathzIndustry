package com.cozystudios.fofrathzindustry;

import java.awt.*;
import java.util.Random;

public class ColorHelper {
    public static Color greenRandomizer()
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 10f;
        float green = randomize.nextFloat() + 0.25f;
        float blue = randomize.nextFloat() / 10f;

        if(green > 1f) green = 1f;

        return new Color(red, green, blue);
    }

    public static Color blackRandomizer()
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 20f;
        float green = randomize.nextFloat() /20f ;
        float blue = randomize.nextFloat() / 20f;

        return new Color(red, green, blue);
    }

    public static Color colorRandomizer()
    {
        Random randomize = new Random();
        float red = randomize.nextFloat();
        float green = randomize.nextFloat();
        float blue = randomize.nextFloat();

        return new Color(red, green, blue);
    }
}
