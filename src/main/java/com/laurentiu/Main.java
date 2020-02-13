package com.laurentiu;

import java.util.Random;
import java.util.Scanner;

public class Main extends Words {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Words enWords = new Words();
        String[] dictionar = enWords.words;

        Random random = new Random();
        int cifraAleatorie = random.nextInt(dictionar.length);
        char litera = '-';
        int indexStocareSirDeLitere = 0;

        String cuvantRandom = dictionar[cifraAleatorie];

        char[] cuvantDeCompletat = new char[cuvantRandom.length()];

        char[] litereIntroduse = new char[20];

        for (int i = 0; i < cuvantDeCompletat.length; i++) {
            cuvantDeCompletat[i] = '_';
        }

        for (int i = 0; i < litereIntroduse.length; i++) {
            litereIntroduse[i] = litera;
        }
        printare(cuvantDeCompletat);

        int nrIncercari = 12;

        while (true) {
            System.out.println("Introduceti o litera: ");
            litera = scanner.next().charAt(0);

            if (!verificareLitere(litereIntroduse, litera)) {
                litereIntroduse[indexStocareSirDeLitere] = litera;
                indexStocareSirDeLitere++;
                nrIncercari--;
            } else {
                System.out.println("Litera a fost deja introdusa.");
            }

            for (int i = 0; i < cuvantRandom.length(); i++) {
                if (litera == cuvantRandom.charAt(i)) {
                    cuvantDeCompletat[i] = litera;
                }
            }

            printare(cuvantDeCompletat);

            if (verificareCuvinte(cuvantRandom, cuvantDeCompletat)) {
                System.out.println("Ai ghicit cuvantul!");
                break;
            }

            System.out.println("Mai ai " + nrIncercari + " incercari");

            if (nrIncercari == 0) {
                System.out.println("GAME OVER!");
                System.out.println("Cuvantul este " + cuvantRandom);
                break;
            }
        }
    }

    public static void printare(char[] cuvantDeCompletat) {
        for (int i = 0; i < cuvantDeCompletat.length; i++) {
            System.out.print(cuvantDeCompletat[i] + " ");
        }
        System.out.println("");
    }

    public static boolean verificareCuvinte(String s, char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificareLitere(char[] sir, char c) {
        for (int i = 0; i < sir.length; i++) {
            if (c == sir[i]) {
                return true;
            }
        }
        return false;
    }


}
