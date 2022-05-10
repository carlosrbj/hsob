package com.hsob.alura.TDD.service;

import com.hsob.alura.TDD.model.Desempenho;
import com.hsob.alura.TDD.model.Funcionario;

public class ReadjustService {

    public void concedeReadjust(Funcionario funcionario, Desempenho desempenho) {
        double reajuste = funcionario.getSalario() * desempenho.readjustmentPercentage();
        funcionario.setReajuste(reajuste);
    }

}
