import java.util.*;

/**
 * Created by admin on 25.5.2016 г..
 */
public class _08_HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] power1 = new String[]{"0", "0", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        List<String> power = Arrays.asList(power1);
        String[] type1 = new String[]{"0", "C", "D", "H", "S"};
        List<String> type = Arrays.asList(type1);
        Map<String, Integer> output = new LinkedHashMap<>();
        Map<String, ArrayList<String>> nameCards = new LinkedHashMap<>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("JOKER")) {
                break;
            }
            String[] tokens = input.split(":");
            String cardsString = tokens[1].substring(1, tokens[1].length());
            String[] cards = cardsString.split(", ");
            if (!output.containsKey(tokens[0])) {
                output.put(tokens[0], 0);
            }
            if (!nameCards.containsKey(tokens[0])) {
                nameCards.put(tokens[0], new ArrayList<>());
            }
            for (int i = 0; i < cards.length; i++) {
                if (!nameCards.get(tokens[0]).contains(cards[i])) {
                    nameCards.get(tokens[0]).add(cards[i]);
                }
            }
        }
        for (String s : nameCards.keySet()) {
            int sum = 0;
            for (int i = 0; i < nameCards.get(s).size(); i++) {
                String card = nameCards.get(s).get(i);
                String powerOfCard = card.substring(0, card.length() - 1);
                String typeOfCard = card.substring(card.length() - 1, card.length());
                sum += power.indexOf(powerOfCard) * type.indexOf(typeOfCard);
            }
            output.put(s, output.get(s) + sum);
        }

        for (String s : output.keySet()) {
            System.out.printf("%s: %d%n", s, output.get(s));
        }
    }
}

