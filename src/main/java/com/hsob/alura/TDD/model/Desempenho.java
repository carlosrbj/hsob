package com.hsob.alura.TDD.model;

public enum Desempenho {
    A_DESEJAR{
        @Override
        public Double readjustmentPercentage(){
            return 0.03;
        }
    },
    BOM{
        @Override
        public Double readjustmentPercentage(){
            return 0.15;
        }
    },
    OTIMO{
        @Override
        public Double readjustmentPercentage(){
            return 0.20;
        }
    };


    public abstract Double readjustmentPercentage();
}

