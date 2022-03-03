package br.com.alura.tdd;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    BonusService bonusService = new BonusService();

    @Test
    @DisplayName("Caso o cálculo de bônus com base no salário for maior que mil, funcionário não receberá nada")
    public void bonusZeroParaSalariosAltos(){
        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(new Funcionario("Thiago", LocalDate.now(), new BigDecimal("25000"))));

        //Para capturar mensagem correta
        /*
        try {
            bonusService.calcularBonus(new Funcionario("Thiago", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception.");
        } catch (Exception e) {
            assertEquals("Funcionário com salário maior que R$ 10.000,00 não pode receber bônus.", e.getMessage());
        }
        */
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
