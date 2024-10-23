package cm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoyleAaronTest1 {
        @Test
        void PeriodClassTestNumber1() {
            int startHour = 8;
            Period period = new Period(8, 10);
            assertNotNull(period);
            assertEquals(startHour, period.getStartHour());
        }

    class rateTests {
        @Test
        void RateClassTestNumber1() {

        }
    }

}
