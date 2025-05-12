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

    /*Метод, печатающий статистику*/
   public void printStatistic() {
        System.out.println("Введите номер месяца");
        selectedMonth = scanner.nextInt();

        /*количество пройденных шагов по дням*/
        MonthData.printDaysAndStepsFromMonth();
        System.out.println();

        /*общее количество шагов за месяц;*/
        System.out.println("Общее количество шагов за месяц: " + MonthData.sumStepsFromMonth());
        System.out.println();

        /*максимальное пройденное количество шагов в месяце;*/
        System.out.println("Максимальное пройденное количество шагов в месяце: " + MonthData.maxSteps());
        System.out.println();

        /*среднее количество шагов;*/
        System.out.println("Среднее количество шагов: " + MonthData.monthlyStepsAverage());
        System.out.println();

        /*пройденная дистанция (в километрах);*/
        System.out.println("Пройденная дистанция (в километрах): " + MonthData.distanceCoveredKm());
        System.out.println();

        /*количество сожжённых килокалорий;*/
        System.out.println("Количество сожжённых килокалорий: " + MonthData.burnedKcal());
        System.out.println();

        /*лучшая серия: максимальное количество подряд идущих дней, в течение которых
        количество шагов за день было равно или выше целевого.*/
        System.out.println("лучшая серия: максимальное количество подряд идущих дней, в течение которых, " +
                "количество шагов за день было равно или выше целевого: " + MonthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }

    /*Метод, добавляющий шаги в статистику в выбранный месяц и день*/
   public void addNewNumberStepsPerDay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();// ввод и проверка номера месяца

        if (month < 1 || month > 12){
            System.out.println("Вы ввели значение: " + month + ", что является недопустимым");
            System.out.println("Месяц должен быть в диапазоне от 1 до 12");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();

        if (day < 1 || day > 30){
            System.out.println("Вы ввели значение: " + day + ", что является недопустимым");
            System.out.println("День должен быть в диапазоне от 1 до 30 и не может быть равным 0");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();

        if (steps < 0) {
            System.out.println("Вы ввели значение: " + steps + ", что является недопустимым");
            System.out.println("Количество шагов не может быть отрицательным");
            return;
        }

        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];
        // сохранение полученных данных
        monthToData[month - 1].days[day - 1] = steps;
    }

    public static void changeStepGoal(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите новое значение цели количества шагов в день: ");
        int newGoal = scanner.nextInt();

        if (newGoal == 0 || newGoal <= goalByStepsPerDay) {
            System.out.println("Вы ввели значение: " + newGoal + ", что является недопустимым");
            System.out.println("Новая цель не может быть меньше или равна текущей, а также равна 0");
        }
        else {goalByStepsPerDay = newGoal;}
    }

}
