package calculator;


import constants.SalaryConstants;
import exceptions.SalaryLimitException;
import salary.Salary;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Service Class for all the logic implementation.
 */

public class SalaryComponents {

    private Salary salary;
    private MathContext roundOff = new MathContext(SalaryConstants.DIVISION_ROUND_OFF);

    public Salary displaySalaryStructure(BigDecimal annualCTC) throws SalaryLimitException {
        if (annualCTC.compareTo(SalaryConstants.LOWER_CTC_LIMIT) >= SalaryConstants.EQUALITY_CHECK_ZERO &&
                annualCTC.compareTo(SalaryConstants.UPPER_CTC_LIMIT) <= SalaryConstants.EQUALITY_CHECK_ZERO) {
            salary = new Salary();
            BigDecimal monthlyCTC = getMctc(annualCTC);
            return salary.withAnnualSalary(annualCTC).withMctc(monthlyCTC)
                    .withBasicPay(getSalarySplitComponent(monthlyCTC))
                    .withHra(getSalarySplitComponent(salary.getBasicPay())).withEdli(getMaxEdliSliptUp()
                    .setScale(SalaryConstants.SCALE_CONSTANT, SalaryConstants.ROUND_OFF))
                    .withSpecialAllowance(calculateSpecialAllowance());
        } else {
            throw new SalaryLimitException("Sorry!!!, Please Enter your Annual CTC between 12000 and 260000(Both Value Inclusive)");
        }
    }

    private BigDecimal getMaxEdliSliptUp() {
        BigDecimal edliSplitUp = getEdliSplitUp();
        return edliSplitUp.compareTo(SalaryConstants.EDLI_CUTOFF_VALUE) > SalaryConstants.EQUALITY_CHECK_ZERO ?
                SalaryConstants.EDLI_CUTOFF_VALUE : edliSplitUp;
    }

    private BigDecimal getEdliSplitUp() {
        return salary.getBasicPay().multiply(SalaryConstants.EDLI_CUTOFF_PERCENT);
    }

    private BigDecimal getSalarySplitComponent(BigDecimal salaryComponent) {
        return SalaryConstants.BASIC_AND_HRA_PERCENT.multiply(salaryComponent, roundOff);
    }

    private BigDecimal getMctc(BigDecimal actc) {
        return actc.divide(SalaryConstants.MONTHS, roundOff);
    }


    private BigDecimal calculateSpecialAllowance() {

        BigDecimal remainingAmount;
        if (salary.getMctc().compareTo(addUpSalaryComp()) > SalaryConstants.EQUALITY_CHECK_ZERO) {
            remainingAmount = salary.getMctc().subtract(addUpSalaryComp());
        } else {
            remainingAmount = addUpSalaryComp().subtract(salary.getMctc());
        }
        BigDecimal specialAllowance;
        if (remainingAmount.compareTo(addUpBasicAndEsi()) >= 0) {
            specialAllowance =   (remainingAmount.subtract(addUpBasicAndEsi())).divide(BigDecimal.ONE.add(
                    SalaryConstants.EMPLOYER_ESI_PERCENT.add(SalaryConstants.PF_PERCENT)), roundOff);
        } else {
            specialAllowance = (addUpBasicAndEsi().subtract(remainingAmount)).divide(BigDecimal.ONE.add(
                    SalaryConstants.EMPLOYER_ESI_PERCENT.add(SalaryConstants.PF_PERCENT)), roundOff);
        }

        BigDecimal pfAmount = calculatePf(specialAllowance);
        if (pfAmount.compareTo(SalaryConstants.PF_CUTOFF_VALUE) > SalaryConstants.EQUALITY_CHECK_ZERO) {
            salary.withEmployeePf(SalaryConstants.PF_CUTOFF_VALUE);
            specialAllowance = remainingAmount.subtract(salary.getEmployeePf().add(calculateEsiOfBasicPayAndHra()))
                    .divide(BigDecimal.ONE.add(SalaryConstants.EMPLOYER_ESI_PERCENT));
        }

        salary.withEmployeeEsi(SalaryConstants.EMPLOYER_ESI_PERCENT.multiply(addBasicPayAndHra().add(specialAllowance)).setScale(2, 4));
        if (SalaryConstants.EMPLOYEE_PF.compareTo(BigDecimal.ZERO) == SalaryConstants.EQUALITY_CHECK_ZERO) {
            salary.withEmployeePf(pfAmount);
        }
        return specialAllowance;
    }

    private BigDecimal addUpBasicAndEsi() {
        return SalaryConstants.PF_PERCENT
        .multiply(salary.getBasicPay()).add(calculateEsiOfBasicPayAndHra());
    }

    private BigDecimal addUpSalaryComp() {
        return addBasicPayAndHra().add(SalaryConstants.BONUS)
                .add(salary.getEdli()).add(SalaryConstants.EMPLOYEE_LWF);
    }

    private BigDecimal calculateEsiOfBasicPayAndHra() {
        return SalaryConstants.EMPLOYER_ESI_PERCENT.multiply(addBasicPayAndHra());
    }

    private BigDecimal calculatePf(BigDecimal specialAllowance) {
        return SalaryConstants.PF_PERCENT.multiply(addBasicPayAndSplAllowance(specialAllowance));
    }

    private BigDecimal addBasicPayAndSplAllowance(BigDecimal specialAllowance) {
        return salary.getBasicPay().add(specialAllowance);
    }

    private BigDecimal addBasicPayAndHra() {
        return salary.getBasicPay().add(salary.getHra());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (salary != null) {
            stringBuilder.append(SalaryConstants.EMPLOYEE_ID).append(SalaryConstants.EMPLOYEE_ID_NUMBER).append("\n")
                    .append(SalaryConstants.NAME).append(SalaryConstants.EMPLOYEE_NAME).append("\n")
                    .append(SalaryConstants.DESIGNATION).append(SalaryConstants.DESIGNATION_NAME).append("\n")
                    .append(SalaryConstants.ANNUAL_SALARY).append(salary.getAnnualSalary().setScale(SalaryConstants.SCALE_CONSTANT)).append("\n")
                    .append(SalaryConstants.MONTHLY_CTC).append(salary.getMctc().setScale(SalaryConstants.SCALE_CONSTANT)).append("\n")
                    .append(SalaryConstants.BASIC_MONTHLY).append(salary.getBasicPay()).append("\n")
                    .append(SalaryConstants.HRA_MONTHLY).append(salary.getHra().setScale(SalaryConstants.SCALE_CONSTANT, SalaryConstants.ROUND_OFF)).append("\n")
                    .append(SalaryConstants.SA_MONTHLY).append(salary.getSpecialAllowance()).append("\n")
                    .append(SalaryConstants.PF_MONTHLY).append(salary.getEmployeePf().setScale(SalaryConstants.SCALE_CONSTANT, SalaryConstants.ROUND_OFF)).append("\n")
                    .append(SalaryConstants.LWF_MONTHLY).append(SalaryConstants.EMPLOYEE_LWF.setScale(SalaryConstants.SCALE_CONSTANT)).append("\n")
                    .append(SalaryConstants.ESI_MONTHLY).append(salary.getEmployeeEsi()).append("\n")
                    .append(SalaryConstants.BONUS_MONTHLY).append(SalaryConstants.BONUS.setScale(SalaryConstants.SCALE_CONSTANT)).append("\n")
                    .append(SalaryConstants.EDLI_MONTHLY).append(salary.getEdli()).append("\n");
        }
        return stringBuilder.toString();
    }
}
