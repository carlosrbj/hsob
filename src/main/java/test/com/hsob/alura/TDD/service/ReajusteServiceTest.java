package test.com.hsob.alura.TDD.service;

import com.hsob.alura.TDD.model.Funcionario;
import com.hsob.alura.TDD.service.ReadjustService;
import org.junit.jupiter.api.*;
import com.hsob.alura.TDD.model.Desempenho;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    private ReadjustService readjustService;
    private Funcionario funcionario;

    @BeforeEach /*INICIALIZA O MÉTODO ANTES DE CADA TESTE*/
    public void iniciaVariaveis(){
        System.out.println("Antes de cada teste");
        this.readjustService = new ReadjustService();
        this.funcionario = new Funcionario("Carlos", LocalDate.now(), 1000.0);
    }
    @AfterEach
    public void depoisDeCadaTeste(){
        System.out.println("Depois de cada teste");
    }

    @BeforeAll
    public static void antesdeTodosTeste(){
        System.out.println("ANTES DE TODOS OS TESTE");
    }

    @AfterAll
    public static void depoisDeTodosTeste(){
        System.out.println("DEPOIS DE TODOS OS TESTES");
    }

    @Test
    public void reajusteTresPorCentoDesempenhoADesejar(){
        readjustService.concedeReadjust(funcionario, Desempenho.A_DESEJAR);
        assertEquals(1030.0, funcionario.getSalario());
    }

    @Test
    public void reajusteQuinzePorCentoDesempenhoBom(){
        readjustService.concedeReadjust(funcionario, Desempenho.BOM);
        assertEquals(1150.0, funcionario.getSalario());
    }

    @Test
    public void reajusteVintePorCentoDesempenhoOtimo(){
        readjustService.concedeReadjust(funcionario, Desempenho.OTIMO);
        assertEquals(1200.0, funcionario.getSalario());
    }

}
