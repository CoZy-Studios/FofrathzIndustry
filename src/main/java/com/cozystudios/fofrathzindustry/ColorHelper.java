package com.cozystudios.fofrathzindustry;

import java.awt.*;
import java.util.Random;

public class ColorHelper {
    public static Color grassRandomizer()
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 10f;
        float green = randomize.nextFloat() * 0.3f + 0.6f;
        float blue = randomize.nextFloat() / 10f;

        return new Color(red, green, blue);
    }

    public static Color coalRandomizer()
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 20f;
        float green = randomize.nextFloat() /20f ;
        float blue = randomize.nextFloat() / 20f;

        return new Color(red, green, blue);
    }

    public static Color copperRandomizer()
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 2f + 0.8f ;
        float green = randomize.nextFloat() / 4f + 0.4f;
        float blue = randomize.nextFloat() / 10f - 0.09f;

        if(red > 1f) red = 1f;
        if(green > 1f) green = 1f;
        if(blue < 0f) blue = 0f;

        return new Color(red, green, blue);
    }
}
