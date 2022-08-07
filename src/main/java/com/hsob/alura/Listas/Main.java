package com.hsob.alura.Listas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Result: " + result());

        StringBuilder sb = new StringBuilder(100);
        String s = "";
        if (sb.equals(s)) {
            System.out.println("First");
        } else if (sb.toString().equals(s.toString())) {
            System.out.println("Second");
        } else {
            System.out.println("Third");
        }
    }

    public static int result() {
        try {
            int a =10/0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally{
            return 3;
        }
    }

}
