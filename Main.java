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
