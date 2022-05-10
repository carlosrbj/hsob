package test.com.hsob.alura.TDD.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hsob.alura.TDD.model.Funcionario;
import com.hsob.alura.TDD.service.BonusService;
import org.junit.jupiter.api.Test;

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
        Double bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), 25000.0));

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        Double bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), 2500.0));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        Double bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), 10000.0));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

/** 
* 
* Method: calcularBonus(Funcionario funcionario) 
* 
*/ 
@Test
public void testCalcularBonus() throws Exception { 
//TODO: Test goes here... 
} 


} 
