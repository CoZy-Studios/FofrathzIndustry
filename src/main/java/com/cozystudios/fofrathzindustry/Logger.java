package com.cozystudios.fofrathzindustry;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    public static List<Class> loggedClasses = new ArrayList<>();

    public static void activateLogger()
    {
        //Just add the classes here you want to have checked
        // addClassToLogger(Classname.class)
        addClassToLogger(Logger.class);
        addClassToLogger(MouseHandler.class);
        addClassToLogger(Building.class);
        addClassToLogger(KeyHandler.class);
    }

    public static void addClassToLogger(Class loggedClass)
    {
        loggedClasses.add(loggedClass);
    }

    public static void log(Class loggedClass,String message)
    {
        if(!loggedClasses.isEmpty() || loggedClass == Logger.class) {
            if (loggedClasses.contains(loggedClass)) {
                String className = loggedClass.getSimpleName();

                System.out.println(className + " : " + message);
            }
        }else log(Logger.class, "logger is empty");
    }
}
