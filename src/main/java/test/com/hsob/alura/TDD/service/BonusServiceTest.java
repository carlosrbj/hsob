package test.com.hsob.alura.TDD.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hsob.alura.TDD.model.Funcionario;
import com.hsob.alura.TDD.service.BonusService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** 
* BonusService Tester. 
* 
* @author <Authors name> 
* @since <pre>mai 9, 2022</pre> 
* @version 1.0 
*/ 
public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
//        teste espera uma exception
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), 25000.0)));
//        try {
//            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), 25000.0));
//            fail("Não deu exception. teste Falhou!");
//        } catch (Exception e){
//            assertEquals("Salário não compativel com a regra de bonus.", e.getMessage());
//        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        Double bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), 2500.0));

        assertEquals(250, bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        Double bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), 10000.0));

        assertEquals(1000, bonus);
    }


} 
