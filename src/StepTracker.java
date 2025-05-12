import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    int selectedMonth;

    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    /*�����, ���������� ����������*/
   void printStatistic() {
        System.out.println("������� ����� ������");
        selectedMonth = scanner.nextInt();
        selectedMonth = selectedMonth - 1;

        /*���������� ���������� ����� �� ����*/
        monthToData[selectedMonth].printDaysAndStepsFromMonth();
        System.out.println();

        /*����� ���������� ����� �� �����;*/
        System.out.println("����� ���������� ����� �� �����: " + monthToData[selectedMonth].sumStepsFromMonth());
        System.out.println();

        /*������������ ���������� ���������� ����� � ������;*/
        System.out.println("������������ ���������� ���������� ����� � ������: " + monthToData[selectedMonth].maxSteps());
        System.out.println();

        /*������� ���������� �����;*/
        System.out.println("������� ���������� �����: " + monthToData[selectedMonth].monthlyStepsAverage());
        System.out.println();

        /*���������� ��������� (� ����������);*/
        System.out.println("���������� ��������� (� ����������): " + monthToData[selectedMonth].distanceCoveredKm());
        System.out.println();

        /*���������� �������� �����������;*/
        System.out.println("���������� �������� �����������: " + monthToData[0].burnedKcal());
        System.out.println();

        /*������ �����: ������������ ���������� ������ ������ ����, � ������� �������
        ���������� ����� �� ���� ���� ����� ��� ���� ��������.*/
        System.out.println("������ �����: ������������ ���������� ������ ������ ����, � ������� �������, " +
                "���������� ����� �� ���� ���� ����� ��� ���� ��������: " + monthToData[selectedMonth].bestSeries(goalByStepsPerDay));
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
        monthData.days[day - 1] = steps;
    }

    public void changeStepGoal(){
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
