package com.hsob.service;

interface Veiculo {
    int getMarcha();
    void liga();
}

abstract class Carro implements Veiculo {
    public void liga()  {
        System.out.println("ligado!");
    }
}

class CarroConcreto extends Carro implements Veiculo{
    public int getMarcha() {
        return 1;
    }
    @Override
    public void liga() {
        System.out.println("liga carro concreto");
    }
}

public class Test {
    public static void main(String[] args) {
        Veiculo v = new Carro() {
            @Override
            public int getMarcha() {
                return 0;
            }
        };

        v.liga();
        v.getMarcha();

        CarroConcreto c = new CarroConcreto();
        c.liga();
        c.getMarcha();
    }


}
