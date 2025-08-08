public class CarsAssemble {
    private static final int CARS_PER_HOUR = 221;
    
    public double productionRatePerHour(int speed) {
        double coef;
        if (speed >= 1 && speed <= 4) {
            coef = 1.0;
        } else if (speed >= 5 && speed <= 8) {
            coef = 0.9;
        } else if (speed == 9) {
            coef = 0.8;
        } else if (speed == 10) {
            coef = 0.77;
        } else if (speed == 0) {
            coef = 0.0;
        } else {
            throw new IllegalArgumentException("Must be in range 0 to 10 inclusivelly");
        }
        
        return CARS_PER_HOUR * coef * speed;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed)/60;
    }
}
