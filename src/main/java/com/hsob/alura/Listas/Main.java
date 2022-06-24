package com.hsob.alura.Listas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        String aula1 = "Conhecendo listas";
        String aula2 = "Modelandoa  classe Aula";
        String aula3 = "Trabalhando com Cursos e Sets";
        String aula4 = "Aumentando conhecimento";

        ArrayList<String> lists = new ArrayList<>();
        lists.add(aula1);
        lists.add(aula2);
        lists.add(aula3);
        lists.add(aula4);


        for (String list: lists ) {
            System.out.println("Aula: " + list);
        }
        System.out.println("\n*********************\n");
        Collections.sort(lists);
        for (String list: lists ) {
            System.out.println("Aula: " + list);
        }
    }

}
