package cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DoyleAaronPeriodTests {
    @Test
    void PeriodClassTestNumber1() {
        int startHour = 8;
        Period period = new Period(8, 10);
        assertNotNull(period);
        assertEquals(startHour, period.getStartHour());
    }

    @Test
    void PeriodClassTestNumber2() {
        int endHour = 12;
        Period period = new Period(8, 12);
        assertNotNull(period);
        assertEquals(endHour, period.getEndHour());
    }

    @Test
    void PeriodClassTestNumber3() {

    }
}
