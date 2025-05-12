import java.util.Scanner;

public class MonthData {
    int[] days = new int[30];

    /*ћетод, который печатает список введеннных данных за выбрранный мес€ц*/
    public void printDaysAndStepsFromMonth() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }

    }

    /*ћетод, расчитывающий общую сумму шагов в выбранном мес€це*/
    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    /*ћетод, расчитывающий максимальное количество шагов*/
    public int maxSteps() {
        int maxSteps = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    /*ћетод, расчитывающий лучшую серию, где количество шагов было больше целевого*/
    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries >= finalSeries) {
                finalSeries = currentSeries;
            }
        }

        return finalSeries;

    }

    /*ћетод расчет среднего количества шагов за мес€ц*/
    public int monthlyStepsAverage(){
        int monthlyStepsAverage =  sumStepsFromMonth() / days.length;
        return monthlyStepsAverage;

    }

    /*ћетод расчета пройденной дистанции*/
    public int distanceCoveredKm() {
        int distanceInKm = Converter.convertToKm(sumStepsFromMonth());
        return distanceInKm;
    }

    /*ћетода расчета сожженных килокалорий*/
    public int burnedKcal() {
        int burnedKcal = Converter.convertStepsToKilocalories(sumStepsFromMonth());
        return burnedKcal;
    }

}
