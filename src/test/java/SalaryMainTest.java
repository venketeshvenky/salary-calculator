

import calculator.SalaryComponents;
import exceptions.SalaryLimitException;
import org.junit.Test;
import salary.Salary;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.assertEquals;

public class SalaryMainTest {

    @Test(expected = SalaryLimitException.class)
    public void checkSalLowerLimit() throws Exception {
        SalaryComponents salaryComponents = new SalaryComponents();
        salaryComponents.displaySalaryStructure(new BigDecimal(1700));
    }

    @Test(expected = SalaryLimitException.class)
    public void checkSalHigherLimit() throws Exception {
        SalaryComponents salaryComponents = new SalaryComponents();
        salaryComponents.displaySalaryStructure(new BigDecimal(170000000));
    }

    @Test
    public void testSalaryStructure() throws Exception {
        SalaryComponents salaryComponents = new SalaryComponents();
        Salary salary = salaryComponents.displaySalaryStructure(new BigDecimal(170000));
        assertEquals(MockConstants.CTC_MONTHLY, salary.getMctc());
        assertEquals(MockConstants.BASIC_MONTHLY, salary.getBasicPay());
        assertEquals(MockConstants.HRA_MONTHLY, salary.getHra());
        assertEquals(MockConstants.SA_MONTHLY, salary.getSpecialAllowance());
        assertEquals(MockConstants.PF_MONTHLY, salary.getEmployeePf().round(new MathContext(5)));
        assertEquals(MockConstants.ESI_MONTHLY, salary.getEmployeeEsi());
        assertEquals(MockConstants.EDLI_MONTHLY, salary.getEdli());
    }
}
