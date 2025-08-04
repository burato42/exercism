public class Lasagna {

    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int passed) {
        return expectedMinutesInOven() - passed;
    }

    public int preparationTimeInMinutes(int layers) {
        return layers * 2;
    } 

    public int totalTimeInMinutes(int layers, int minutes) {
        return preparationTimeInMinutes(layers) + minutes;
    }
}
