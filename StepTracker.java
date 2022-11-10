
public class StepTracker extends Converter {
    private int stepGoal = 10000;

    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public int getStepGoal() {
        return stepGoal;
    }

    public void setStepGoal(int stepGoal) {
        this.stepGoal = stepGoal;
    }

    public void setStepsDay(int stepsDay, int month, int day) {
        monthToData[month].getDays()[day] = stepsDay;
    }

    public int getStepsMonth(int month) { // Общее количество шагов за месяц
        int sum = 0;
        for (int i = 0; i < monthToData[month].getDays().length; i++) {
            sum += monthToData[month].getDays()[i];
        }
        return sum;
    }

    // Максимальное пройденное количество шагов в месяце
    public int maxStepsMonth(int month) {
        int max = monthToData[month].getDays()[0];
        for (int i = 1; i < monthToData[month].getDays().length; i++) {
            if (max < monthToData[month].getDays()[i]) {
                max = monthToData[month].getDays()[i];
            }
        }
        return max;
    }

    public int stepsAvrDay(int month) { // Среднее количество шагов
        int sum = 0;
        for (int i = 0; i < monthToData[month].getDays().length; i++) {
            sum += monthToData[month].getDays()[i];
        }
        return sum / monthToData[month].getDays().length;
    }

// Лучшая серия: максимальное количество подряд идущих дней
    public int bestSeries(int month) {
        int count = 0;
        for (int i = 0; i < monthToData[month].getDays().length; i++) {
            if (monthToData[month].getDays()[i] >= getStepGoal()) {
                count++;
            }
        }
        return count;
    }

    double metersStep(int month) { // Пройденная дистанция (в км)
        return stepsAvrDay(month) * getMetersStep();
    }

    double burnedCalories(int inputMonth) { // Количество сожжённых килокалорий
        return getStepsMonth(inputMonth) * getKilocaloriesPerStep();
    }

    void stepsByDay(int month) { // Количество пройденных шагов по дням
        for(int i = 0; i < monthToData[month].getDays().length; i++) {
            if(i != monthToData[month].getDays().length) {
                System.out.println(i + " день: " + monthToData[month].getDays()[i] + ",");
            } else {
                System.out.println(i + " день: " + monthToData[month].getDays()[i]);
            }
        }
    }

}

class MonthData {
    // Заполните класс самостоятельно
    int[] days = new int[30];

    public int[] getDays() {
        return days;
    }
}