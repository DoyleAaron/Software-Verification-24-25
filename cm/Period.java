package cm;
public class Period {
    private final int startHour;
    private final int endHour;

    // Constructor
    public Period(int startHour, int endHour) {
        // Validate start and end hours
        if (startHour < 0 || startHour >= 24) {
            throw new IllegalArgumentException("Start hour must be between 0 and 23 (inclusive).");
        }
        if (endHour <= 0 || endHour > 24) {
            throw new IllegalArgumentException("End hour must be between 1 and 24 (inclusive).");
        }
        if (startHour >= endHour) {
            throw new IllegalArgumentException("Start hour must be less than end hour.");
        }
        this.startHour = startHour;
        this.endHour = endHour;
    }

    // Getters
    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    // Duration method: returns the duration in hours
    public int duration() {
        return endHour - startHour;
    }

    // Overlaps method: checks if two periods overlap
    public boolean overlaps(Period period) {
        return this.startHour < period.getEndHour() && this.endHour > period.getStartHour();
    }
}

// ChatGPT made the dummy classes so that the tests won't error
