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
