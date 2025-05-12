public class Converter {


    /*Метод, который преобразует шаги в километры*/
    public static int convertToKm(int steps) {
        int stepsInKm = (int) (steps * 0.00075);
        return stepsInKm;
    }

    /*Метод, котоырй переводит шаги в килокалории*/
    public static int convertStepsToKilocalories(int steps) {
        int stepsInKcal = (steps * 50) / 1000;
        return stepsInKcal;
    }

}
