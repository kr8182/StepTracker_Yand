import java.util.Scanner;

public class MonthData {
    int[] days = new int[30];

    /*�����, ������� �������� ������ ���������� ������ �� ���������� �����*/
    public void printDaysAndStepsFromMonth() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " ����: " + days[i]);
        }

    }

    /*�����, ������������� ����� ����� ����� � ��������� ������*/
    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    /*�����, ������������� ������������ ���������� �����*/
    public int maxSteps() {
        int maxSteps = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    /*�����, ������������� ������ �����, ��� ���������� ����� ���� ������ ��������*/
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

    /*����� ������ �������� ���������� ����� �� �����*/
    public int monthlyStepsAverage(){
        int monthlyStepsAverage =  sumStepsFromMonth() / days.length;
        return monthlyStepsAverage;

    }

    /*����� ������� ���������� ���������*/
    public int distanceCoveredKm() {
        int distanceInKm = Converter.convertToKm(sumStepsFromMonth());
        return distanceInKm;
    }

    /*������ ������� ��������� �����������*/
    public int burnedKcal() {
        int burnedKcal = Converter.convertStepsToKilocalories(sumStepsFromMonth());
        return burnedKcal;
    }

}
