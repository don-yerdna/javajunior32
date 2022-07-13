package lesson10;

public interface IPlayer {

    /**
     * Интерфейс - это набросок будущего класса
     * 1 правило - объект данного интерфейса создать нельзя
     * 2 правило - все методы не имеют тела. т.е. являются наброском того, что должно быть внутри класса
     *
     * @param card
     */
    void addCardToHand(Card card);
    boolean needCard();
    void openHand();
    void setName(String name);
}
