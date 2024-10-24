package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DoyleAaronRateTests {
    @Test
    void RateClassTestNumber1() {
        // Testing for a valid car park kind
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);

        assertNotNull(rate);
    }

    @Test
    void RateClassTestNumber2() {
        // Testing for a valid hourlyNormalRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(5);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);

        assertNotNull(rate);
    }

    @Test
    void RateClassTestNumber3() {
        // Testing for a valid hourlyReducedRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(6);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);

        assertNotNull(rate);
    }

    @Test
    void RateClassTestNumber4() {
        // This is testing for lower boundary of hourlyNormalRate & hourlyReducedRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(0);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(0);

        Rate rate = new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);

        assertNotNull(rate);
    }

    @Test
    void RateClassTestNumber5() {
        // This is testing for upper boundary of hourlyNormalRate & hourlyReducedRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(10);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(10);

        Rate rate = new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);

        assertNotNull(rate);
    }

    @Test
    void RateClassTestNumber6() {
        // This is testing for when hourlyNormalRate and hourlyReducedRate are the same value
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(8);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(8);

        Rate rate = new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);

        assertNotNull(rate);
    }

    @Test
    void RateClassTestNumber7() {
        // This is testing for an invalid hourlyNormalRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(50);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(10);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber8() {
        // This is testing for an invalid hourlyReducedRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(5);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(25);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber9() {
        // This is testing for the invalid lower boundary on hourlyNormalRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(-1);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(5);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber10() {
        // This is testing for the invalid upper boundary on hourlyNormalRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(11);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(5);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber11() {
        // This is testing for the invalid lower boundary on hourlyReducedRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(-1);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber12() {
        // This is testing for the invalid lower boundary on hourlyReducedRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(11);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber13() {
        // This is testing for when hourlyReducedRate is greater than hourlyNormalRate
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(5);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber14() {
        // This is testing for when hourlyReducedRate & hourlyNormalRate are both null
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 24;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(-1);

        assertThrows(NullPointerException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, null, null);}
        );
    }
}
