package lesson10;

public interface IBlackJack {

    void addPlayerToGame(Player player);

    void dealTwoCardsToAllPlayers();

    void dealRestCardsToAllPlayers();

    void printWinner();
}
