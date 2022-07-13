package lesson10;

public class Dealer extends Player {
    @Override
    public boolean needCard() {
        if (valuesHand() < 17) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void openHand() {
        System.out.println("Карты крупье сумма: " + valuesHand());
        for (Card c : hand) {
            System.out.println(c.getName());
        }

    }
}
