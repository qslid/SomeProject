package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void  main(String args[]){
        String[] langs = {"Java","python","c#","kotlin"};

        List <String> langlist = Arrays.asList(langs);

        for(String l : langlist){
            System.out.println("Я хочу выучить "+ l);
        }

    }
}
