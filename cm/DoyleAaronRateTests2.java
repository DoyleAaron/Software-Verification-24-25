package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
public class DoyleAaronRateTests2 {
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

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, null, null);}
        );
    }

    @Test
    void RateClassTestNumber15() {
        // This is testing for when the periods are null
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

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, null, null, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber16() {
        // This is testing for when the periods are overlapping
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 11;
        int reducedPeriodEnd = 15;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber17() {
        // This is testing for when the normal periods in a single list are overlapping with each other
        int normalPeriodStart1 = 9;
        int normalPeriodEnd1 = 12;
        int normalPeriodStart2 = 11;
        int normalPeriodEnd2 = 15;

        int reducedPeriodStart = 16;
        int reducedPeriodEnd = 18;

        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart1, normalPeriodEnd1));
        normalPeriod.add(new Period(normalPeriodStart2, normalPeriodEnd2));

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));

        BigDecimal hourlyNormalRate = new BigDecimal(2);
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);
                });
    }

    @Test
    void RateClassTestNumber18() {
        // This is testing for when only one of hourlyReducedRate & hourlyNormalRate is null
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

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, normalPeriod, reducedPeriod, hourlyNormalRate, null);}
        );
    }

    @Test
    void RateClassTestNumber19() {
        // This is testing for when the reducedPeriods is null
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

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, null, normalPeriod, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber20() {
        // This is testing for when the normalPeriods is null
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

        assertThrows(IllegalArgumentException.class,
                () -> {new Rate(kind, reducedPeriod, null, hourlyNormalRate, hourlyReducedRate);}
        );
    }

    @Test
    void RateClassTestNumber21(){
        // This is testing for when the reduced periods in a single list are overlapping with each other
        int normalPeriodStart = 15;
        int normalPeriodEnd = 18;


        int reducedPeriodStart1 = 9;
        int reducedPeriodEnd1 = 12;
        int reducedPeriodStart2 = 11;
        int reducedPeriodEnd2 = 14;

        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));


        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart1, reducedPeriodEnd1));
        reducedPeriod.add(new Period(reducedPeriodStart2, reducedPeriodEnd2));

        BigDecimal hourlyNormalRate = new BigDecimal(2);
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);
                });
    }

    @Test
    void RateClassTestNumber22(){
        // This is testing for when the reduced periods in a single list are overlapping with the normal period
        int normalPeriodStart = 11;
        int normalPeriodEnd = 14;


        int reducedPeriodStart1 = 9;
        int reducedPeriodEnd1 = 12;
        int reducedPeriodStart2 = 13;
        int reducedPeriodEnd2 = 15;

        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));


        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart1, reducedPeriodEnd1));
        reducedPeriod.add(new Period(reducedPeriodStart2, reducedPeriodEnd2));

        BigDecimal hourlyNormalRate = new BigDecimal(2);
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);
                });
    }

    @Test
    void RateClassTestNumber23() {
        // This is testing for when the normal periods in a single list are overlapping with the reduced period
        int normalPeriodStart1 = 9;
        int normalPeriodEnd1 = 12;
        int normalPeriodStart2 = 13;
        int normalPeriodEnd2 = 15;

        int reducedPeriodStart = 11;
        int reducedPeriodEnd = 14;

        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart1, normalPeriodEnd1));
        normalPeriod.add(new Period(normalPeriodStart2, normalPeriodEnd2));

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));

        BigDecimal hourlyNormalRate = new BigDecimal(2);
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);
                });
    }

    @Test
    void RateClassTestNumber24() {
        // This is checking to ensure duplicate periods throw an error
        int normalPeriodStart1 = 9;
        int normalPeriodEnd1 = 12;
        int normalPeriodStart2 = 10;
        int normalPeriodEnd2 = 12;

        int reducedPeriodStart = 12;
        int reducedPeriodEnd = 14;

        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart1, normalPeriodEnd1));
        normalPeriod.add(new Period(normalPeriodStart2, normalPeriodEnd2));
        normalPeriod.add(new Period(normalPeriodStart2, normalPeriodEnd2));

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));

        BigDecimal hourlyNormalRate = new BigDecimal(2);
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);
                });
    }

    @Test
    void CalculateMethodTestNumber1() {
        // This is testing the price is calculating correctly for a full normal period stay
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

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(10,12);

        BigDecimal expectedOutcome = new BigDecimal("4"); // Putting this in quotations was suggested by chatGPT as I was having issues with the leading 0's at the end

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber2() {
        // This is testing the price is calculating correctly for a full reduced period stay
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

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(21,23);

        BigDecimal expectedOutcome = new BigDecimal("2");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber3() {
        // This is testing the price is calculating correctly for a stay during the free period
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

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(1,5);

        BigDecimal expectedOutcome = new BigDecimal("0");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber4() {
        // This is testing the price is calculating correctly for a stay during the normal and reduced period
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

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(18,22);

        BigDecimal expectedOutcome = new BigDecimal("4");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber5() {
        // This is testing the price is calculating correctly for a stay during the normal and free period
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

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(8,10);

        BigDecimal expectedOutcome = new BigDecimal("2");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber6() {
        // This is testing the price is calculating correctly for a stay during the reduced and free period
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 22;
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(21,24);

        BigDecimal expectedOutcome = new BigDecimal("1");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber7() {
        // This is testing the price calculation over normal, reduced, and free periods
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

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        // Define a periodStay that overlaps with normal, reduced, and free periods
        Period periodStay = new Period(8, 21);  // Example time range, adjust as necessary

        BigDecimal expectedOutcome = new BigDecimal("21");  // Replace with the correct expected result for this test

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber8() {
        // This is testing that the visitor car park is free if the cost is below 10
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 22;
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(21,24);

        BigDecimal expectedOutcome = new BigDecimal("0");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber9() {
        // This is testing that the visitor car park is half price after the cost price 10 mark has been hit
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 22;
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(10);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(11,14);

        BigDecimal expectedOutcome = new BigDecimal("10");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber10() {
        // This is testing that the minimum payable is 4
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 22;
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(21,22);

        BigDecimal expectedOutcome = new BigDecimal("4");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber11() {
        // This is testing that the minimum payable is 4 but gives the normal cost if its over 4
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 22;
        CarParkKind kind = CarParkKind.MANAGEMENT;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(11,14);

        BigDecimal expectedOutcome = new BigDecimal("6");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber12() {
        // This is testing that the rate is normal below 5.50
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 22;
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(2);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(11,13);

        BigDecimal expectedOutcome = new BigDecimal("4.00");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }

    @Test
    void CalculateMethodTestNumber13() {
        // Testing that 25% reduction is applied when it's above 5.50
        int normalPeriodStart = 9;
        int normalPeriodEnd = 19;
        int reducedPeriodStart = 20;
        int reducedPeriodEnd = 22;
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new Period(normalPeriodStart, normalPeriodEnd));
        BigDecimal hourlyNormalRate = new BigDecimal(3);

        ArrayList<Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new Period(reducedPeriodStart, reducedPeriodEnd));
        BigDecimal hourlyReducedRate = new BigDecimal(1.5);

        Rate rate = new Rate(kind, reducedPeriod, normalPeriod, hourlyNormalRate, hourlyReducedRate);

        Period periodStay = new Period(11, 15);

        BigDecimal expectedOutcome = new BigDecimal("10.38");

        assertEquals(expectedOutcome, rate.calculate(periodStay));
    }
}
