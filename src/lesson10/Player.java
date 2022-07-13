package lesson10;

import java.util.ArrayList;
import java.util.Scanner;

public class Player implements IPlayer{
    private String name;
    protected ArrayList<Card> hand = new ArrayList<>();
    private boolean canWin = true;

    public boolean isCanWin() {
        return canWin;
    }

    public void setCanWin(boolean canWin) {
        this.canWin = canWin;
    }

    @Override
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    @Override
    public boolean needCard() {
        if (this.valuesHand()<=21) {
            this.openHand();
            System.out.println("нужна ли еще одна карта? (Да/Нет)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("да")) return true;
            return false;
        } else {
            System.out.println("Перебор");
            System.out.println();
            return false;
        }
    }

    @Override
    public void openHand() {
        System.out.println("Карты "+this.name+" сумма: "+valuesHand());
        for (Card c:hand){
            System.out.println(c.getName());
        }

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int valuesHand(){
        int values=0;
        for (Card c:hand){
            values += c.getValue();
        }
        return values;
    }
}
