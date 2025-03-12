package com.cozystudios.fofrathzindustry;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    public static List<Class> loggedClasses;

    public Logger() {
        loggedClasses = new ArrayList<Class>();
    }

    public static void addClassToLogger(Class loggedClass)
    {
        loggedClasses.add(loggedClass);
    }

    public static void log(Class loggedClass,String message, Boolean HasIssues)
    {
        if(loggedClasses.contains(loggedClass))
        {
            String className = loggedClass.getClass().getSimpleName();
            if(HasIssues){
                System.out.println("!Error! " +className + " : " + message);
            }
            System.out.println(className + " : " + message);

        }
    }
    public static void log(Class loggedClass,String message)
    {
        if(loggedClasses.contains(loggedClass))
        {
            String className = loggedClass.getClass().getSimpleName();

            System.out.println(className + " : " + message);
        }
    }
}
