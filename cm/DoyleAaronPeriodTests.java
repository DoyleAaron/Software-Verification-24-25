package cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoyleAaronPeriodTests {
    @Test
    void PeriodClassTestNumber1() {
        // This is to test a valid start hour
        int startHour = 8;
        Period period = new Period(8, 10);
        assertNotNull(period);
        assertEquals(startHour, period.getStartHour());
    }

    @Test
    void PeriodClassTestNumber2() {
        //This is to test a valid end hour
        int endHour = 12;
        Period period = new Period(8, 12);
        assertNotNull(period);
        assertEquals(endHour, period.getEndHour());
    }

    @Test
    void PeriodClassTestNumber3() {
        // This tests an invalid start hour
        int startHour = -1;
        int endHour = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(startHour, endHour);
        });
    }

    @Test
    void PeriodClassTestNumber4() {
        // This tests an invalid end hour
        int startHour = 8;
        int endHour = 25;
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(startHour, endHour);
        });
    }

    @Test
    void PeriodClassTestNumber5() {
        // This is testing for a valid upper boundary
        int endHour = 24;
        Period period = new Period(20, 24);
        assertNotNull(period);
        assertEquals(endHour, period.getEndHour());
    }

    @Test
    void PeriodClassTestNumber6() {
        // This is testing for a valid lower boundary
        int startHour = 0;
        Period period = new Period(0, 5);
        assertNotNull(period);
        assertEquals(startHour, period.getStartHour());
    }

    @Test
    void PeriodClassTestNumber7() {
        // This is testing for when the start time is greater than the end time
        int startHour = 12;
        int endHour = 8;
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(startHour, endHour);
        });
    }

    @Test
    void PeriodClassTestNumber8() {
        // This is testing for when the start and end time are the same
        int startHour = 12;
        int endHour = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            new Period(startHour, endHour);
        });
    }
    
}
