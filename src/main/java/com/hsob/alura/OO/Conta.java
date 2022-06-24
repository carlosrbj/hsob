package com.hsob.alura.OO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conta {
    private Double saldo;
    private Integer agencia;
    private Integer numero;
    private String titular;
}
