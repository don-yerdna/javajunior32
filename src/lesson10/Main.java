package lesson10;

public class Main {
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        Dealer dealer = new Dealer();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        player1.setName("Вася");
        player2.setName("Петя");
        player3.setName("Гена");
        player4.setName("Коля");

        blackJack.addPlayerToGame(player1);
        blackJack.addPlayerToGame(player2);
        blackJack.addPlayerToGame(player3);
        blackJack.addPlayerToGame(player4);
        blackJack.addPlayerToGame(dealer);

        blackJack.dealTwoCardsToAllPlayers();
        blackJack.dealRestCardsToAllPlayers();

        blackJack.printWinner();
    }
}
