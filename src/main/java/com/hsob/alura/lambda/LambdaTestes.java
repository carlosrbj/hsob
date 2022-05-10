package com.hsob.alura.lambda;

import java.util.List;
import java.util.function.Predicate;

public class LambdaTestes {
    interface Printer{
        void printMessage();
    }

    static class A {
        int a = 0;

        public static void main(String[] args) {
            new A().method(1, a -> a > 0); // A
        }

        private void method(int a, Predicate<Integer> d) {
            if(d.test(a)){ // B
                System.out.println(a);
            }
        }
    }

    static class B{
        int a = 0;

        public static void main(String[] args) {
            new B().method(1, a -> a > 0); // A
        }

        private void method(int a, Predicate<Integer> d) {
            if(d.test(a)){ // B
                System.out.println(a);
            }
        }
    }
}
