package br.com.alura.tdd;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import static org.junit.jupiter.api.Assertions.assertEquals;;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Thiago", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    @DisplayName("Deve ser dado um reajuste salarial de 3 por cento para desempenho a desejar")
    public void reajusteDeTresPorCentoParaADesejar(){
        reajusteService.concedeReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    @DisplayName("Deve ser dado um reajuste salarial de 15 por cento para desempenho Bom")
    public void reajusteDeQuinzePorCentoParaDesempenhoBom(){
        reajusteService.concedeReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    @DisplayName("Deve ser dado um reajuste salarial de 20 por cento para desempenho Ótimo")
    public void reajusteDeVintePorCentoParaDesempenhoBom(){
        reajusteService.concedeReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.0"),funcionario.getSalario());
    }
}
