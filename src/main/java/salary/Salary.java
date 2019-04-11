package salary;

import java.math.BigDecimal;

/**
 * Salary DTO class
 */

public class Salary {

    private BigDecimal mctc;
    private BigDecimal annualSalary;
    private BigDecimal basicPay;
    private BigDecimal hra;
    private BigDecimal specialAllowance;
    private BigDecimal employeeEsi;
    private BigDecimal employeePf;
    private BigDecimal edli;

    public BigDecimal getMctc() {
        return mctc;
    }

    public Salary withMctc(BigDecimal mctc) {
        this.mctc = mctc;
        return this;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public Salary withAnnualSalary(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
        return this;
    }

    public BigDecimal getBasicPay() {
        return basicPay;
    }

    public Salary withBasicPay(BigDecimal basicPay) {
        this.basicPay = basicPay;
        return this;
    }

    public BigDecimal getHra() {
        return hra;
    }

    public Salary withHra(BigDecimal hra) {
        this.hra = hra;
        return this;
    }

    public BigDecimal getSpecialAllowance() {
        return specialAllowance;
    }

    public Salary withSpecialAllowance(BigDecimal specialAllowance) {
        this.specialAllowance = specialAllowance;
        return this;
    }

    public BigDecimal getEmployeeEsi() {
        return employeeEsi;
    }

    public Salary withEmployeeEsi(BigDecimal employeeEsi) {
        this.employeeEsi = employeeEsi;
        return this;
    }

    public BigDecimal getEdli() {
        return edli;
    }

    public Salary withEdli(BigDecimal edli) {
        this.edli = edli;
        return this;
    }

    public BigDecimal getEmployeePf() {
        return employeePf;
    }

    public Salary withEmployeePf(BigDecimal employeePf) {
        this.employeePf = employeePf;
        return this;
    }
}
