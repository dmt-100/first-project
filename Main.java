import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                System.out.println("Введите месяц за который хотите внести данные " +
                        "(где 0 - это Январь... 11 - Декабрь):");
                int inputMonth = scanner.nextInt();
                System.out.println("Введите день начиная с 0 по 29 число:");
                int inputDay = scanner.nextInt();
                System.out.println("Введите количество пройденных сегодня шагов:");
                int stepsDay = scanner.nextInt();
                if (stepsDay < 0) {
                    System.out.println("Количество шагов не может быть отрицательным");
                } else {
                    tracker.setStepsDay(stepsDay, inputMonth, inputDay);
                }

            } else if (userInput == 2) {
                System.out.println("Введите число месяца за который хотите посмотреть статистику:");
                int inputMonth2 = scanner.nextInt();
                System.out.println("В этом месяце Вы прошли: " +
                        tracker.getStepsMonth(inputMonth2));
                System.out.println("Максимальное пройденное количество шагов в месяце за день: " +
                        tracker.maxStepsMonth(inputMonth2));
                System.out.println("Среднее количество шагов: " +
                        tracker.stepsAvrDay(inputMonth2));
                System.out.println("Пройденная дистанция (в км) в месяц: " +
                        tracker.metersStep(inputMonth2));
                System.out.println("Количество сожжённых килокалорий в месяц: " +
                        tracker.burnedCalories(inputMonth2));
                System.out.println("Лучшая серия дней составляет: " +
                        tracker.bestSeries(inputMonth2));
                System.out.println("Количество пройденных шагов по дням:");
                tracker.stepsByDay(inputMonth2);

            } else if (userInput == 3) {
                System.out.println("Введите целевое число сколько хотите пройти за день: ");
                int inputGoal = scanner.nextInt();
                if (inputGoal < 0) {
                    System.out.println("Число не может быть отрицательным, попробуйте заново.");
                } else {
                    tracker.setStepGoal(inputGoal);
                    System.out.println("Ваша новая цель количество шагов за день составляет " +
                            + tracker.getStepGoal());
                }

            } else if (userInput == 0) {
                System.out.println("Выход.");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена.");
       }

    private static void printMenu() {
        System.out.println("Введите команду от нуля до трех, где:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("0 - Выход");

    }

}