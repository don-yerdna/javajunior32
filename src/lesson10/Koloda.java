package lesson10;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Koloda implements IKoloda {
    ArrayList<Card> cards = new ArrayList<>();

    public Koloda() {
        this.preparedCards();
    }

    public void preparedCards() {
        cards.add(new Card("Двойка треф", 2));
        cards.add(new Card("Двойка черва", 2));
        cards.add(new Card("Двойка пика", 2));
        cards.add(new Card("Двойка бубна", 2));

        cards.add(new Card("Тройка треф", 3));
        cards.add(new Card("Тройка черва", 3));
        cards.add(new Card("Тройка пика", 3));
        cards.add(new Card("Тройка бубна", 3));

        cards.add(new Card("Четверка треф", 4));
        cards.add(new Card("Четверка черва", 4));
        cards.add(new Card("Четверка пика", 4));
        cards.add(new Card("Четверка бубна", 4));

        cards.add(new Card("Пятерка треф", 5));
        cards.add(new Card("Пятерка черва", 5));
        cards.add(new Card("Пятерка пика", 5));
        cards.add(new Card("Пятерка бубна", 5));

        cards.add(new Card("Шестерка треф", 6));
        cards.add(new Card("Шестерка черва", 6));
        cards.add(new Card("Шестерка пика", 6));
        cards.add(new Card("Шестерка бубна", 6));

        cards.add(new Card("Семерка треф", 7));
        cards.add(new Card("Семерка черва", 7));
        cards.add(new Card("Семерка пика", 7));
        cards.add(new Card("Семерка бубна", 7));

        cards.add(new Card("Восьмерка треф", 8));
        cards.add(new Card("Восьмерка черва", 8));
        cards.add(new Card("Восьмерка пика", 8));
        cards.add(new Card("Восьмерка бубна", 8));

        cards.add(new Card("Девятка треф", 9));
        cards.add(new Card("Девятка черва", 9));
        cards.add(new Card("Девятка пика", 9));
        cards.add(new Card("Девятка бубна", 9));

        cards.add(new Card("Десятка треф", 10));
        cards.add(new Card("Десятка черва", 10));
        cards.add(new Card("Десятка пика", 10));
        cards.add(new Card("Десятка бубна", 10));

        cards.add(new Card("Валет треф", 10));
        cards.add(new Card("Валет черва", 10));
        cards.add(new Card("Валет пика", 10));
        cards.add(new Card("Валет бубна", 10));

        cards.add(new Card("Дама треф", 10));
        cards.add(new Card("Дама черва", 10));
        cards.add(new Card("Дама пика", 10));
        cards.add(new Card("Дама бубна", 10));

        cards.add(new Card("Король треф", 10));
        cards.add(new Card("Король черва", 10));
        cards.add(new Card("Король пика", 10));
        cards.add(new Card("Король бубна", 10));

        cards.add(new Card("Туз треф", 11));
        cards.add(new Card("Туз черва", 11));
        cards.add(new Card("Туз пика", 11));
        cards.add(new Card("Туз бубна", 11));
    }


    @Override
    public Card getRandomCard() {
        // ДЗ - сделать, чтобы колода уменьшалась
        int index = ThreadLocalRandom.current().nextInt(0, cards.size());
        return cards.get(index);
    }
}
