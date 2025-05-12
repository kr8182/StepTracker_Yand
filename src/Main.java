import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MonthData monthData = new MonthData();

        StepTracker tracker = new StepTracker(scanner);


        while (true) {

            printMenu();

            int cmd = scanner.nextInt();

            if (cmd == 1) {
                tracker.addNewNumberStepsPerDay();

            } else if (cmd == 2) {
                tracker.changeStepGoal();

            } else if (cmd == 3) {
                tracker.printStatistic();

            } else if (cmd == 4){
                break;

            } else {
                System.out.println("����� ������� �� ����������");
            }

        }

    }
    static void printMenu() {
        System.out.println("�������� ���� �� ������:");
        System.out.println("1. ������ ���������� ����� �� ����");
        System.out.println("2. �������� ���� �� ���������� ����� � ����;");
        System.out.println("3. ���������� ���������� �� ����������� �����");
        System.out.println("4. ��������� ���������");
    }
}

