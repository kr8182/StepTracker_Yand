public class Converter {


    /*�����, ������� ����������� ���� � ���������*/
    public static int convertToKm(int steps) {
        int stepsInKm = (int) (steps * 0.00075);
        return stepsInKm;
    }

    /*�����, ������� ��������� ���� � �����������*/
    public static int convertStepsToKilocalories(int steps) {
        int stepsInKcal = (steps * 50) / 1000;
        return stepsInKcal;
    }

}
