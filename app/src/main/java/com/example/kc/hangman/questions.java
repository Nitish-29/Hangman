package com.example.kc.hangman;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by KC on 31-Jul-17.
 */
public class questions {

    public String getText1() {
        String result = "RANDOM#RANDOM";
        ArrayList<String> words = new ArrayList<String>();
        words.add("LIKE A VIRGIN#Single Recorded by Madonna ");
        words.add(" CRAXYSEXYCOOL#Recorded by R&B and TLC");
        words.add("JUST DANCE#Song by Lady Gaga");
        words.add(" BURGER#Food : Bun and Patty");
        words.add(" SUNFLOWER#Flower: Give me some sunshine :) ");
        words.add("KUNG FU PANDA#Po the Dragon Warrier");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }

    public String getText2() {
        String result = "KIDS#KIDS";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" BURGER# Food: Bun and Patty");
        words.add(" JUNGLE# Dictionary : Lion is the king of ........!");
        words.add(" HOTDOG# Food: Sausage in the Bun");
        words.add(" SUNFLOWER# Flower: Give me some sunshine :) ");
        words.add("BUGS BUNNY# Cartoon : What's up");
        words.add("KUNG FU PANDA# Po the Dragon Warrier");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }
    public String getText3() {
        String result = "MOVIES#MOVIES";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" ANACONDA# World's largest and deadliest snake");
        words.add("BRAD PITT# Adoptive father of Maddox and Zahara");
        words.add(" CINDERELLA# THE Little Glass Slipper");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }

    public String getText4() {
        String result = "TV#SERIES";
        ArrayList<String> words = new ArrayList<String>();
        words.add("AMERICAN IDOL# Food: The search for Superstar");
        words.add("THE SIMPSONS# Flower: Homer,Marge,Bart,Lisa and Maggie");
        words.add("SESAME STREET# Educational Children TV Series");
        words.add("HANNAH MONTANA# Teenage comedy-drama and musical show");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }
    public String getText5() {
        String result = "PLACES#PLACES";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" THAILAND# Capital City: Bangkok ");
        words.add(" AMERICA# U.S.A is also know as .......");
        words.add("SOUTH AFRICA# City: Cape Town");
        words.add(" GRENADA# Also known as Island of Spies ");
        words.add(" ATHENS# Ancient Greek City");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }

    public String getText6() {
        String result = "DICTIONERY#DICTIONERY";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" STRIDENT# Strict");
        words.add(" TERMINATE#To begin to an end");
        words.add(" VIGOROUS#Robust");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }
    public String getText7() {
        String result = "PERSON#ALITY";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" STRIDENT# Strict");
        words.add(" TERMINATE#To begin to an end");
        words.add(" VIGOROUS#Robust");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }

    public String getText8() {
        String result = "HARRY#POTTER";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" GRYFFINDOR# Harry's House");
        words.add("AVADA KEDAVRA# The Unforgiven Curse");
        words.add("ORDINARY WIZARD LEVEL # O.W.L. stand for?");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }

    public String getText9() {
        String result = "FOOD#FOOD";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" BECHAMEL# Mother suase of French Cuisine");
        words.add(" TONIC# Gin and ______");
        words.add(" CARAMEL# Burnt Sugar");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }

    public String getText10() {
        String result = "ANIMALS#ANIMALS";
        ArrayList<String> words = new ArrayList<String>();
        words.add(" IGUANA# HERBIVORUS LIZARD");
        words.add(" COBRA# A venomous snake");
        words.add(" BEAR# Baloo and Yogi");
        words.add(" Mouse# Mickey and Minnie");
        words.add(" ALBRATROS# One of the largest flying bird");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }

    public String getText11() {
        String result = "MUSIC#MUSIC";
        ArrayList<String> words = new ArrayList<String>();
        words.add("LIKE A VIRGIN#Single Recorded by Madonna ");
        words.add(" CRAXYSEXYCOOL#Recorded by R&B and TLC");
        words.add("JUST DANCE#Song by Lady Gaga");
        Random generator = new Random();
        int randomIndex = generator.nextInt(words.size());
        result = words.get(randomIndex);
        return result;
    }
}
