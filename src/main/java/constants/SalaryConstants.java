package constants;

import java.math.BigDecimal;

public class SalaryConstants {
    public static final BigDecimal BASIC_AND_HRA_PERCENT = new BigDecimal(.5);
    public static final BigDecimal BONUS = new BigDecimal(1500.00);
    public static final BigDecimal EMPLOYEE_LWF = new BigDecimal(20.00);
    public static final BigDecimal MONTHS = new BigDecimal(12);
    public static final BigDecimal EDLI_CUTOFF_VALUE = new BigDecimal(172.5);
    public static BigDecimal EMPLOYEE_PF = new BigDecimal(0);
    public static final BigDecimal EDLI_CUTOFF_PERCENT = new BigDecimal(.0115);
    public static final BigDecimal PF_PERCENT = new BigDecimal(.12);
    public static final BigDecimal EMPLOYER_ESI_PERCENT = new BigDecimal(.0475);
    public static final BigDecimal PF_CUTOFF_VALUE = new BigDecimal(1800);
    public static final String EMPLOYEE_ID = "EMP#                        : ";
    public static final String EMPLOYEE_ID_NUMBER = "670018";
    public static final String NAME = "NAME                        : ";
    public static final String EMPLOYEE_NAME = "Venketesh A";
    public static final String DESIGNATION = "Designation (old)           : ";
    public static final String DESIGNATION_NAME = "SE ";
    public static final String ANNUAL_SALARY = "CTC(Annual)                 : ";
    public static final String MONTHLY_CTC = "CTC(Monthly)                : ";
    public static final String BASIC_MONTHLY = "Basic(Monthly)              : ";
    public static final String HRA_MONTHLY = "HRA (Monthly)               : ";
    public static final String SA_MONTHLY = "Special Allowance (Monthly) : ";
    public static final String PF_MONTHLY = "ER PF (monthly)             : ";
    public static final String LWF_MONTHLY = "ER S&E (monthly)            : ";
    public static final String ESI_MONTHLY = "ER ESI (monthly)            : ";
    public static final String BONUS_MONTHLY = "Bonus (Monthly)             : ";
    public static final String EDLI_MONTHLY = "EDLI (Monthly)              : ";
    public static final int SCALE_CONSTANT = 2;
    public static final int ROUND_OFF = 4;
    public static final int DIVISION_ROUND_OFF = 5;
    public static final int EQUALITY_CHECK_ZERO = 0;
    public static final BigDecimal LOWER_CTC_LIMIT = new BigDecimal(12000);
    public static final BigDecimal UPPER_CTC_LIMIT = new BigDecimal(260000);

}
