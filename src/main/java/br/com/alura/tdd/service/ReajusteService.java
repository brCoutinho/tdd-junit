package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concedeReajuste(Funcionario funcionario, Desempenho desempenho){
        funcionario.reajustarSalario(funcionario.getSalario().multiply(desempenho.percentualReajuste()));
    }
}
