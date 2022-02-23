package br.com.alura.tdd;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    BonusService bonusService = new BonusService();

    @Test
    @DisplayName("Caso o cálculo de bônus com base no salário for maior que mil, funcionário não receberá nada")
    public void bonusZeroParaSalariosAltos(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Thiago", LocalDate.now(), new BigDecimal("25000")));

        assertEquals(BigDecimal.ZERO, bonus);

    }

    @Test
    @DisplayName("Caso o salário de um funcionário seja menor ou igual que 10 mil ele deverá receber bônus")
    public void bonusParaFuncionariosComSalarioMenorIgualQueDezMil(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Thiago", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal(("250.0")), bonus);

    }

    @Test
    @DisplayName("Caso o salário seja dez mil o funcionário deve receber mil")
    public void bonusDeMilReaisParaSalarioDeDezMil(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Thiago", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal(("1000.0")), bonus);

    }
}
