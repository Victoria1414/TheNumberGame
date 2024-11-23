
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        // Ініціалізація випадкового числа та інших змінних
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Число від 1 до 100
        Scanner scanner = new Scanner(System.in);
        int guess;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Гра 'Вгадай число'!");
        System.out.println("Комп'ютер загадав число від 1 до 100. Спробуйте його вгадати!");

        // Цикл гри
        while (!guessedCorrectly) {
            System.out.print("Введіть ваше число: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Вітаємо! Ви вгадали число " + targetNumber + " за " + attempts + " спроб.");
                guessedCorrectly = true;
            } else if (guess < targetNumber) {
                System.out.println("Загадане число більше!");
            } else {
                System.out.println("Загадане число менше!");
            }
        }

        scanner.close();
    }
}
