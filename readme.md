# Гра "Вгадай число"

## Опис гри
Гра "Вгадай число" — це проста текстова гра, де комп’ютер загадує число, а гравець намагається його відгадати. Після кожної спроби гравець отримує підказку, чи є загадане число більшим чи меншим.
## Ціль гри:
Гравець повинен відгадати загадане число за найменшу кількість спроб.

## Правила гри
1. Комп’ютер генерує випадкове число від 1 до 100.
2. Гравець вводить свої спроби через консоль.
3. Після кожної спроби програма:
   - повідомляє, чи є загадане число більшим або меншим від введеного;
   - завершує гру, якщо число вгадано.
4. Гравець може зробити будь-яку кількість спроб, поки не вгадає число.

## Модульний дизайн гри 
1. Main Class (точка входу)
Відповідає за запуск гри та взаємодію з користувачем.
 ```java
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameIO io = new GameIO();

        io.printMessage("Ласкаво просимо до гри 'Вгадай число'!");
        io.printMessage("Комп'ютер загадує число від 1 до 100.");

        game.startGame(io);

        io.printMessage("Дякуємо за гру!");
    }
}

 ```
1. Game Logic Class
Містить основну логіку гри: генерація числа, перевірка відповідей гравця, підрахунок спроб.
 ```java
import java.util.Random;

public class Game {
    private int targetNumber;
    private int attempts;

    public Game() {
        resetGame();
    }

    // Генерує нову гру
    private void resetGame() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        attempts = 0;
    }

    // Запуск гри
    public void startGame(GameIO io) {
        boolean isCorrect = false;

        while (!isCorrect) {
            int userGuess = io.getUserInput("Введіть ваше число: ");
            attempts++;
            isCorrect = checkGuess(userGuess, io);
        }

        io.printMessage("Ви вгадали число " + targetNumber + " за " + attempts + " спроб.");
    }

    // Перевірка відповіді
    private boolean checkGuess(int guess, GameIO io) {
        if (guess == targetNumber) {
            return true;
        } else if (guess < targetNumber) {
            io.printMessage("Загадане число більше!");
        } else {
            io.printMessage("Загадане число менше!");
        }
        return false;
    }
}

 ```
3. Input/Output Module
Обробляє введення/виведення, щоб відділити логіку від взаємодії з користувачем.
 ```java
import java.util.Scanner;

public class GameIO {
    private final Scanner scanner = new Scanner(System.in);

    // Вивід повідомлення
    public void printMessage(String message) {
        System.out.println(message);
    }

    // Зчитування вводу
    public int getUserInput(String prompt) {
        printMessage(prompt);
        while (!scanner.hasNextInt()) {
            printMessage("Будь ласка, введіть ціле число.");
            scanner.next(); // Очистка неправильного вводу
        }
        return scanner.nextInt();
    }
}

 ```

## Проста імплементація 
https://www.jdoodle.com/online-java-compiler
 ```java
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
 ```
 ```
