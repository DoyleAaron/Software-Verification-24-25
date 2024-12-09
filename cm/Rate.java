package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods, BigDecimal normalRate, BigDecimal reducedRate) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if(normalRate.intValue() > 10 || reducedRate.intValue() > 10){
            throw new IllegalArgumentException("Neither the reduced or normal hourly rate can't be above 10");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }
    public BigDecimal calculate(Period periodStay) {
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal cost = (hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours)))
                .add(hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        switch (kind) {
            case VISITOR:
                if (cost.intValue() <= 10) {
                    return new BigDecimal(0);
                } else {
                    cost = cost.subtract(new BigDecimal(10));
                    cost = cost.divide(new BigDecimal(2));
                    return cost;
                }
            case STAFF:
                if (cost.intValue() <= 16) {
                    return cost;
                } else {
                    return new BigDecimal(16);
                }
            case STUDENT:
                if(cost.intValue() <= 5.5) {
                    return cost.setScale(2, BigDecimal.ROUND_HALF_UP);
                } else {
                    cost = cost.subtract(new BigDecimal(5.5));
                    cost = cost.multiply(new BigDecimal("0.75"));
                    cost = cost.add(new BigDecimal(5.5));
                    return cost.setScale(2, BigDecimal.ROUND_HALF_UP);
                }
            case MANAGEMENT:
                if (cost.intValue() <= 4) {
                    return new BigDecimal(4);
                } else {
                    return cost;
                }
            default:
                throw new IllegalArgumentException("Invalid Kind given");
        }
    }

}