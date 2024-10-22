package cm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
class Rate {
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

class Period {
    private int startHour;
    private int endHour;

    public Period(int start, int end) {

    }

    public boolean overlaps(Period period) {
        return false; // Placeholder so it doesn't error
    }

    public int duration() {
        return 1; // Placeholder so it doesn't error
    }
}
 // ChatGPT helped in making the dummy classes so that the tests won't error
public class DoyleAaronTest1 {
    class periodTests {
        @Test
        void PeriodClassTestNumber1() {
    
        }
    }

    class rateTests {
        @Test
        void RateClassTestNumber1() {

        }
    }

}
