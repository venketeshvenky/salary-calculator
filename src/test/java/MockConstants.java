import java.math.BigDecimal;
import java.math.MathContext;

public class MockConstants {

    public static final BigDecimal CTC_MONTHLY =  new BigDecimal(14167.00);
    public static final BigDecimal BASIC_MONTHLY =  new BigDecimal(7083.5);
    public static final BigDecimal HRA_MONTHLY =  new BigDecimal(3541.80, new MathContext(5));
    public static final BigDecimal SA_MONTHLY =  new BigDecimal(501.51, new MathContext(5));
    public static final BigDecimal PF_MONTHLY =  new BigDecimal(910.20, new MathContext(5));
    public static final BigDecimal ESI_MONTHLY =  new BigDecimal(528.52, new MathContext(5));
    public static final BigDecimal EDLI_MONTHLY =  new BigDecimal(81.46, new MathContext(4));
}
