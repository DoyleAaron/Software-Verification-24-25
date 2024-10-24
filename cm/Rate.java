package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Rate {
    private final CarParkKind kind;
    private final ArrayList<Period> normalPeriods;
    private final ArrayList<Period> reducedPeriods;
    private final BigDecimal hourlyNormalRate;
    private final BigDecimal hourlyReducedRate;

    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods,
                BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate) {
        // Validate inputs
        if (kind == null) {
            throw new IllegalArgumentException("CarParkKind cannot be null");
        }
        if (hourlyNormalRate.compareTo(BigDecimal.ZERO) < 0 || hourlyNormalRate.compareTo(new BigDecimal(10)) > 0) {
            throw new IllegalArgumentException("Normal rate must be between 0 and 10");
        }
        if (hourlyReducedRate.compareTo(BigDecimal.ZERO) < 0 || hourlyReducedRate.compareTo(new BigDecimal(10)) > 0) {
            throw new IllegalArgumentException("Reduced rate must be between 0 and 10");
        }
        if (hourlyNormalRate.compareTo(hourlyReducedRate) < 0) {
            throw new IllegalArgumentException("Normal rate must be greater than or equal to reduced rate");
        }
        this.kind = kind;
        this.normalPeriods = normalPeriods;
        this.reducedPeriods = reducedPeriods;
        this.hourlyNormalRate = hourlyNormalRate;
        this.hourlyReducedRate = hourlyReducedRate;

        // Validate periods
        validatePeriods();
    }

    public BigDecimal calculate(Period periodStay) {
        BigDecimal totalCharge = BigDecimal.ZERO;

        // Loop through each hour in the stay
        for (int hour = periodStay.getStartHour(); hour < periodStay.getEndHour(); hour++) {
            if (isInNormalPeriod(hour)) {
                totalCharge = totalCharge.add(hourlyNormalRate);
            } else if (isInReducedPeriod(hour)) {
                totalCharge = totalCharge.add(hourlyReducedRate);
            }
        }

        // Return total charge rounded to two decimal places
        return totalCharge.setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isInNormalPeriod(int hour) {
        // Check if the hour is in any of the normal periods
        for (Period normal : normalPeriods) {
            if (normal.overlaps(new Period(hour, hour + 1))) {
                return true;
            }
        }
        return false;
    }

    private boolean isInReducedPeriod(int hour) {
        // Check if the hour is in any of the reduced periods
        for (Period reduced : reducedPeriods) {
            if (reduced.overlaps(new Period(hour, hour + 1))) {
                return true;
            }
        }
        return false;
    }

    private void validatePeriods() {
        // Ensure no overlapping periods within normal or reduced periods
        validateNoOverlappingPeriods(normalPeriods);
        validateNoOverlappingPeriods(reducedPeriods);

        // Ensure normal and reduced periods do not overlap
        for (Period normal : normalPeriods) {
            for (Period reduced : reducedPeriods) {
                if (normal.overlaps(reduced)) {
                    throw new IllegalArgumentException("Normal and reduced periods must not overlap");
                }
            }
        }
    }

    private void validateNoOverlappingPeriods(ArrayList<Period> periods) {
        for (int i = 0; i < periods.size(); i++) {
            for (int j = i + 1; j < periods.size(); j++) {
                if (periods.get(i).overlaps(periods.get(j))) {
                    throw new IllegalArgumentException("Periods must not overlap");
                }
            }
        }
    }

    // Getters for testing purposes
    public CarParkKind getKind() {
        return kind;
    }

    public BigDecimal getHourlyNormalRate() {
        return hourlyNormalRate;
    }

    public BigDecimal getHourlyReducedRate() {
        return hourlyReducedRate;
    }

    public ArrayList<Period> getNormalPeriods() {
        return normalPeriods;
    }

    public ArrayList<Period> getReducedPeriods() {
        return reducedPeriods;
    }
}

// ChatGPT made the dummy classes so that the tests won't error
