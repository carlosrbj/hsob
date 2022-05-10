package test.com.hsob.alura.TDD.service;

import com.hsob.alura.TDD.model.Funcionario;
import com.hsob.alura.TDD.service.ReadjustService;
import org.junit.jupiter.api.Test;
import com.hsob.alura.TDD.model.Desempenho;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteTresPorCentoDesempenhoADesejar(){
        ReadjustService readjustService = new ReadjustService();
        Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), 1000.0);
//      3% de reajuste com desempenho a desejar = 1030.00
        readjustService.concedeReadjust(funcionario, Desempenho.A_DESEJAR);

        assertEquals(1030.0, funcionario.getSalario());
    }

    @Test
    public void reajusteQuinzePorCentoDesempenhoBom(){
        ReadjustService readjustService = new ReadjustService();
        Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), 1000.0);
//      15% de reajuste com desempenho bom = 1150.00
        readjustService.concedeReadjust(funcionario, Desempenho.BOM);
        assertEquals(1150.0, funcionario.getSalario());
    }

    @Test
    public void reajusteVintePorCentoDesempenhoOtimo(){
        ReadjustService readjustService = new ReadjustService();
        Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), 1000.0);
//      15% de reajuste com desempenho otimo = 1200.00
        readjustService.concedeReadjust(funcionario, Desempenho.OTIMO);
        assertEquals(1200.0, funcionario.getSalario());
    }

}
