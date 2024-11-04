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
    }

    @Test
    void PeriodClassTestNumber2() {
        //This is to test a valid end hour
        int endHour = 12;
        Period period = new Period(8, 12);
        assertNotNull(period);
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
    }

    @Test
    void PeriodClassTestNumber6() {
        // This is testing for a valid lower boundary
        int startHour = 0;
        Period period = new Period(0, 5);
        assertNotNull(period);
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

    @Test
    void OverlapsMethodTestNumber1() {
        // This to test when there is an overlap occurring between the periods
        Period period1 = new Period(12,15);
        Period period2 = new Period(12,17);

        assertTrue(period1.overlaps(period2));
    }

    @Test
    void OverlapsMethodTestNumber2() {
        // This is to test when there is no overlap between the periods
        Period period1 = new Period(12,15);
        Period period2 = new Period(20,23);

        assertFalse(period1.overlaps(period2));
    }

    @Test
    void OverlapsMethodTestNumber3() {
        // This is to test no overlap on the boundary of the periods
        Period period1 = new Period(12,15);
        Period period2 = new Period(15,18);

        assertFalse(period1.overlaps(period2));
    }

    @Test
    void OverlapsMethodTestNumber4() {
        // This is to test when the periods are the exact same
        Period period1 = new Period(12,15);
        Period period2 = new Period(12,15);

        assertTrue(period1.overlaps(period2));
    }

    @Test
    void DurationMethodTestNumber1() {
        // This is to test a valid duration
        int duration = 8;
        Period period = new Period(12,20);
        assertEquals(duration, period.duration());
    }

    @Test
    void DurationMethodTestNumber2() {
        // This is to test duration with the lower boundary
        int duration = 5;
        Period period = new Period(0,5);
        assertEquals(duration, period.duration());
    }

    @Test
    void DurationMethodTestNumber3() {
        // This is to test duration with the upper boundary
        int duration = 4;
        Period period = new Period(20,24);
        assertEquals(duration, period.duration());
    }
}
