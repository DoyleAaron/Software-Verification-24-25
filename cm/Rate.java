package cm;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Rate {
    private CarParkKind kind;
    private ArrayList<Period> reducedPeriods;
    private ArrayList<Period> normalPeriods;
    private BigDecimal normalRate;
    private BigDecimal reducedRate;

    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods, BigDecimal normalRate, BigDecimal reducedRate) {

    }

    public BigDecimal calculate(Period periodStay) {
        return BigDecimal.ZERO; // Placeholder so that the test won't error
    }

    public enum CarParkKind {

    }
}
