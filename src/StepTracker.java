import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    static MonthData[] monthToData = new MonthData[12];

    static int selectedMonth;

    static int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    /*�����, ���������� ����������*/
   public void printStatistic() {
        System.out.println("������� ����� ������");
        selectedMonth = scanner.nextInt();

        /*���������� ���������� ����� �� ����*/
        MonthData.printDaysAndStepsFromMonth();
        System.out.println();

        /*����� ���������� ����� �� �����;*/
        System.out.println("����� ���������� ����� �� �����: " + MonthData.sumStepsFromMonth());
        System.out.println();

        /*������������ ���������� ���������� ����� � ������;*/
        System.out.println("������������ ���������� ���������� ����� � ������: " + MonthData.maxSteps());
        System.out.println();

        /*������� ���������� �����;*/
        System.out.println("������� ���������� �����: " + MonthData.monthlyStepsAverage());
        System.out.println();

        /*���������� ��������� (� ����������);*/
        System.out.println("���������� ��������� (� ����������): " + MonthData.distanceCoveredKm());
        System.out.println();

        /*���������� �������� �����������;*/
        System.out.println("���������� �������� �����������: " + MonthData.burnedKcal());
        System.out.println();

        /*������ �����: ������������ ���������� ������ ������ ����, � ������� �������
        ���������� ����� �� ���� ���� ����� ��� ���� ��������.*/
        System.out.println("������ �����: ������������ ���������� ������ ������ ����, � ������� �������, " +
                "���������� ����� �� ���� ���� ����� ��� ���� ��������: " + MonthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }

    /*�����, ����������� ���� � ���������� � ��������� ����� � ����*/
   public void addNewNumberStepsPerDay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ����� ������");
        int month = scanner.nextInt();// ���� � �������� ������ ������

        if (month < 1 || month > 12){
            System.out.println("�� ����� ��������: " + month + ", ��� �������� ������������");
            System.out.println("����� ������ ���� � ��������� �� 1 �� 12");
            return;
        }

        System.out.println("������� ���� �� 1 �� 30 (������������)");
        int day = scanner.nextInt();

        if (day < 1 || day > 30){
            System.out.println("�� ����� ��������: " + day + ", ��� �������� ������������");
            System.out.println("���� ������ ���� � ��������� �� 1 �� 30 � �� ����� ���� ������ 0");
            return;
        }

        System.out.println("������� ���������� �����");
        int steps = scanner.nextInt();

        if (steps < 0) {
            System.out.println("�� ����� ��������: " + steps + ", ��� �������� ������������");
            System.out.println("���������� ����� �� ����� ���� �������������");
            return;
        }

        // ��������� ���������������� ������� MonthData �� �������
        MonthData monthData = monthToData[month - 1];
        // ���������� ���������� ������
        monthToData[month - 1].days[day - 1] = steps;
    }

    public static void changeStepGoal(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ����� �������� ���� ���������� ����� � ����: ");
        int newGoal = scanner.nextInt();

        if (newGoal == 0 || newGoal <= goalByStepsPerDay) {
            System.out.println("�� ����� ��������: " + newGoal + ", ��� �������� ������������");
            System.out.println("����� ���� �� ����� ���� ������ ��� ����� �������, � ����� ����� 0");
        }
        else {goalByStepsPerDay = newGoal;}
    }

}
