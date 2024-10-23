package cm;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Rate {
    private final CarParkKind kind;
    private final ArrayList<Period> reducedPeriods;
    private final ArrayList<Period> normalPeriods;
    private final BigDecimal normalRate;
    private final BigDecimal reducedRate;

    // Constructor
    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods,
                BigDecimal normalRate, BigDecimal reducedRate) {
        // Validate rates
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || normalRate.compareTo(BigDecimal.TEN) > 0) {
            throw new IllegalArgumentException("Normal rate must be between 0 and 10.");
        }
        if (reducedRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.TEN) > 0) {
            throw new IllegalArgumentException("Reduced rate must be between 0 and 10.");
        }
        if (normalRate.compareTo(reducedRate) < 0) {
            throw new IllegalArgumentException("Normal rate must be greater than or equal to reduced rate.");
        }

        // Validate periods for overlap
        for (Period p1 : normalPeriods) {
            for (Period p2 : reducedPeriods) {
                if (p1.overlaps(p2)) {
                    throw new IllegalArgumentException("Normal and reduced periods cannot overlap.");
                }
            }
        }

        this.kind = kind;
        this.reducedPeriods = reducedPeriods;
        this.normalPeriods = normalPeriods;
        this.normalRate = normalRate;
        this.reducedRate = reducedRate;
    }

    // Calculate method
    public BigDecimal calculate(Period periodStay) {
        BigDecimal totalCharge = BigDecimal.ZERO;

        // Calculate charge for normal periods
        for (Period normalPeriod : normalPeriods) {
            if (periodStay.overlaps(normalPeriod)) {
                int overlapHours = calculateOverlapHours(periodStay, normalPeriod);
                totalCharge = totalCharge.add(normalRate.multiply(BigDecimal.valueOf(overlapHours)));
            }
        }

        // Calculate charge for reduced periods
        for (Period reducedPeriod : reducedPeriods) {
            if (periodStay.overlaps(reducedPeriod)) {
                int overlapHours = calculateOverlapHours(periodStay, reducedPeriod);
                totalCharge = totalCharge.add(reducedRate.multiply(BigDecimal.valueOf(overlapHours)));
            }
        }

        // Return the final amount rounded to 2 decimal places
        return totalCharge.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    // Helper method to calculate overlapping hours between two periods
    private int calculateOverlapHours(Period stayPeriod, Period ratePeriod) {
        int overlapStart = Math.max(stayPeriod.getStartHour(), ratePeriod.getStartHour());
        int overlapEnd = Math.min(stayPeriod.getEndHour(), ratePeriod.getEndHour());
        return Math.max(0, overlapEnd - overlapStart);  // Ensure non-negative
    }
}
// ChatGPT made the dummy classes so that the tests won't error
