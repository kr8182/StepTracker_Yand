import java.util.Scanner;

public class MonthData {
    int[] days = new int[30];

    /*�����, ������� �������� ������ ���������� ������ �� ���������� �����*/
    public static void printDaysAndStepsFromMonth() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < StepTracker.monthToData[StepTracker.selectedMonth].days.length; i++) {
            System.out.println((i + 1) + " ����: " + StepTracker.monthToData[StepTracker.selectedMonth].days[i]);
        }

    }

    /*�����, ������������� ����� ����� ����� � ��������� ������*/
    public static int sumStepsFromMonth() {
        Scanner scanner = new Scanner(System.in);

        int sumSteps = 0;

        for (int i = 0; i < StepTracker.monthToData[StepTracker.selectedMonth].days.length; i++) {
            sumSteps += StepTracker.monthToData[StepTracker.selectedMonth].days[i];
        }
        return sumSteps;
    }

    /*�����, ������������� ������������ ���������� �����*/
    public static int maxSteps() {
        Scanner scanner = new Scanner(System.in);
        int maxSteps = 0;

        for (int i = 0; i < StepTracker.monthToData[StepTracker.selectedMonth].days.length; i++) {
            if (StepTracker.monthToData[StepTracker.selectedMonth].days[i] > maxSteps) {
                maxSteps = StepTracker.monthToData[StepTracker.selectedMonth].days[i];
            }
        }
        return maxSteps;
    }

    /*�����, ������������� ������ �����, ��� ���������� ����� ���� ������ ��������*/
    public static int bestSeries(int goalByStepsPerDay) {
        Scanner scanner = new Scanner(System.in);
        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < StepTracker.monthToData[StepTracker.selectedMonth].days.length; i++) {
            if (StepTracker.monthToData[StepTracker.selectedMonth].days[i] >= StepTracker.goalByStepsPerDay) {
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

    /*����� ������ �������� ���������� ����� �� �����*/
    public static int monthlyStepsAverage(){
        int monthlyStepsAverage =  MonthData.sumStepsFromMonth() / StepTracker.monthToData[StepTracker.selectedMonth].days.length;
        return monthlyStepsAverage;

    }

    /*����� ������� ���������� ���������*/
    public static int distanceCoveredKm() {
        int distanceInKm = Converter.convertToKm(MonthData.sumStepsFromMonth());
        return distanceInKm;
    }

    /*������ ������� ��������� �����������*/
    public static int burnedKcal() {
        int burnedKcal = Converter.convertStepsToKilocalories(MonthData.sumStepsFromMonth());
        return burnedKcal;
    }

}
