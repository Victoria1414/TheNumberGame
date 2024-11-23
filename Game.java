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
