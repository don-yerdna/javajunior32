package lesson10;

import java.util.ArrayList;

public class BlackJack implements IBlackJack {
    private Koloda koloda = new Koloda();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> winners = new ArrayList<>();
    private ArrayList<Player> luckyOnes = new ArrayList<>();
    private ArrayList<Player> losers = new ArrayList<>();

    @Override
    public void addPlayerToGame(Player player) {
        if (players.size() < 9) {
            players.add(player);
        } else {
            System.out.println("нет свободных мест");
        }

    }

    @Override
    public void dealTwoCardsToAllPlayers() {
        for (Player p : players) {
            p.addCardToHand(koloda.getRandomCard());
            p.addCardToHand(koloda.getRandomCard());
        }
    }

    @Override
    public void dealRestCardsToAllPlayers() {
        for (Player p : players) {
            while (p.needCard()) {
                p.addCardToHand(koloda.getRandomCard());
            }
        }

    }

    @Override
    public void printWinner(){
        for (Player p:players){
            if (p.valuesHand()>21){
                p.setCanWin(false);
            }
        }

        if (countPlayersWhoCanWin()==0){
            for (Player p:players){
                if (p instanceof Dealer){
                    System.out.println("Победил крупье");
                    p.openHand();
                    return;
                }
            }
        }

        int valueWinner = 0;
        for (Player p:players){
            if (p.isCanWin()&& p.valuesHand()>valueWinner){
                valueWinner = p.valuesHand();
            }
        }

        for (Player p: players){
            if (p.valuesHand() == valueWinner){
                System.out.println("Победитель "+ p.getName());
                p.openHand();
            }
        }
    }

    public  int countPlayersWhoCanWin(){
        int count = 0;
        for (Player p:players){
            if (p.isCanWin()){
                count++;
            }
        }
        return count;
    }

    public void printWin() {
        int dealerValuesHand = 0;
        for (Player p : players) {
            p.openHand();
            System.out.println();
            if (p.getName() == null) {
                dealerValuesHand = p.valuesHand();
            }
        }

        if (dealerValuesHand > 0 && dealerValuesHand <= 21) {
            for (Player p : players) {
                if (p.getName() != null) {
                    if (p.valuesHand() <= 21) {
                        if (p.valuesHand() > dealerValuesHand) {
                            winners.add(p);
                        } else if (p.valuesHand() == dealerValuesHand) {
                            luckyOnes.add(p);
                        } else {
                            losers.add(p);
                        }
                    } else {
                        losers.add(p);
                    }
                }
            }
            for (Player p : players) {
                if (p.getName() == null && winners.size() >= 1) {
                    losers.add(p);
                }
            }
        } else {
            for (Player p : players) {
                if (p.getName() != null && p.valuesHand() <= 21) {
                    winners.add(p);
                } else {
                    losers.add(p);
                }
            }
        }


        if (dealerValuesHand > 0 && dealerValuesHand <= 21 && winners.size() == 0 && luckyOnes.size() == 0) {
            System.out.println("Победил крупье и набрал: " + dealerValuesHand);
        } else if (winners.size() >= 1 || luckyOnes.size() >= 1) {
            if (winners.size() >= 1) {
                for (Player w : winners) {
                    System.out.println(w.getName() + " победил и набрал: " + w.valuesHand());
                }
            }
            if (luckyOnes.size() >= 1) {
                for (Player l : luckyOnes) {
                    System.out.println(l.getName() + " остался \"при своих\" и набрал: " + l.valuesHand());
                }
            }
        } else {
            System.out.println("победивших нет...");
        }

        if (losers.size() >= 1) {
            for (Player l : losers) {
                if (l.valuesHand() > 21) {
                    System.out.println(l.getName() != null ? "У " + l.getName() + " перебор и набрал " + l.valuesHand() : "крупье перебор и набрал " + l.valuesHand());
                } else {
                    System.out.println(l.getName() != null ? l.getName() + " проиграл и набрал " + l.valuesHand() : "крупье проиграл и набрал " + l.valuesHand());
                }
            }
        }

    }
}
