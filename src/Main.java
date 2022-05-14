import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();


        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                System.out.println("Введите номер месяца от 0 до 11");
                int numberMonth = scanner.nextInt();
                System.out.println("Введите день от 0 до 29");
                int numberDay = scanner.nextInt();
                System.out.println("Введите количество шагов ");
                int countSteps = scanner.nextInt();
                // сделать так, чтобы возвращалось к введите количество шагов через вайл
                if (countSteps < 0) {
                    System.out.println("Количество шагов должно быть не отрицательным ");
                    continue;
                }
                stepTracker.inputSteps(numberMonth, numberDay, countSteps);


            } else if (userInput == 2) {
                System.out.println("Введите номер месяца от 0 до 11");
                int numberMonth = scanner.nextInt();
                stepTracker.statisticsSteps(numberMonth);


            } else if (userInput == 3) {
                System.out.println("Какую цель вы хотите ввести? ");
                int newGoal = scanner.nextInt();
                if (newGoal>=0){
                    stepTracker.changeGoalSteps (newGoal);
                } else {
                    System.out.println("Введённое значение не может быть отрицательным. Покторите попытку снова. ");
                }



            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Напечатать статистику за месяц ");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}

