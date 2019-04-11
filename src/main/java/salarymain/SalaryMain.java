package salarymain;

import calculator.SalaryComponents;
import exceptions.SalaryLimitException;

import java.math.BigDecimal;

/**
 * SalaryMain method takes configurable Program Argument as input.
 */
public class SalaryMain {

    public static void main(String[] args) {
        try {
            BigDecimal annualCTC = BigDecimal.valueOf(Double.parseDouble(args[0]));
            SalaryComponents salaryComponents = new SalaryComponents();
            salaryComponents.displaySalaryStructure(annualCTC);
            System.out.println(salaryComponents.toString());
        } catch (SalaryLimitException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
