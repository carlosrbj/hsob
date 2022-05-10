package com.hsob.alura.lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Pessoa{
    String nome;
    int idade;
    Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    public String toString(){
        return nome;
    }
}

interface Matcher<T>{
    boolean test(T t);
}

class FiltradorDePessoas{

    List<Pessoa> filtra (List<Pessoa> pessoas, Predicate<Pessoa> matcher){
        List<Pessoa> resultado = new ArrayList<>();

        for (Pessoa pessoa : pessoas){
            if (matcher.test(pessoa)){
                resultado.add(pessoa);
            }
        }
        return resultado;
    }

}

//class MaioresDeIdade implements Matcher<Pessoa>{
//
//    @Override
//    public boolean test(Pessoa pessoa) {
//        return pessoa.idade >= 18;
//    }
//}



public class LambdaExpressions {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Carlos", 31),
                new Pessoa("Maria", 32),
                new Pessoa("Joao", 17),
                new Pessoa("regina", 15)
        );

        FiltradorDePessoas filtrador = new FiltradorDePessoas();

        Predicate<Pessoa> criteria = new Predicate<Pessoa>() {
            public boolean test(Pessoa pessoa) {
                return pessoa.idade >= 18;
            }
        };

        Predicate<Pessoa> criteriaLambda = pessoa -> pessoa.idade >= 18;

        List<Pessoa> resultado = filtrador.filtra(pessoas, criteria);
        List<Pessoa> resultado2 = filtrador.filtra(pessoas, pessoa -> pessoa.idade >= 18);
        List<Pessoa> resultado3 = filtrador.filtra(pessoas, pessoa -> pessoa.nome.startsWith("M"));

        System.out.println(resultado + "\n" + resultado2 + "\n" + resultado3);



    }
}
