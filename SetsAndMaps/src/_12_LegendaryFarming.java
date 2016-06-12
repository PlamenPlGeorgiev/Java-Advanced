import java.util.Scanner;
import java.util.TreeMap;

public class _12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> keyMatsQuantity = new TreeMap<>();
        keyMatsQuantity.put("fragments", 0);
        keyMatsQuantity.put("motes", 0);
        keyMatsQuantity.put("shards", 0);
        TreeMap<String, Integer> junkQuantity = new TreeMap<>();
        String input = sc.nextLine().toLowerCase();
        StringBuilder keymat = new StringBuilder();
        while (true) {
            if (input.length()<=0) {
                break;
            }
            String[] tokens = input.split(" ");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1];
                if (keyMatsQuantity.containsKey(material)) {
                    keyMatsQuantity.put(material, keyMatsQuantity.get(material) + quantity);
                    if (keyMatsQuantity.get(material) >= 250) {
                        switch (material) {
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                keyMatsQuantity.put(material, keyMatsQuantity.get(material) - 250);
                                keymat.append(material);
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                keyMatsQuantity.put(material, keyMatsQuantity.get(material) - 250);
                                keymat.append(material);
                                break;
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                keyMatsQuantity.put(material, keyMatsQuantity.get(material) - 250);
                                keymat.append(material);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                } else {
                    if (!junkQuantity.containsKey(material)) {
                        junkQuantity.put(material, 0);
                    }
                    junkQuantity.put(material, junkQuantity.get(material) + quantity);
                }
            }
            if (keyMatsQuantity.containsKey(keymat.toString())) {
                    break;
            }
            input = sc.nextLine().toLowerCase();
        }
        keyMatsQuantity.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(entry -> {
                    String mat = entry.getKey();
                    Integer value = entry.getValue();
                    System.out.printf("%s: %d%n", mat, value);
                });
        junkQuantity.entrySet().stream()
                .forEach(entry -> {
                    String mat = entry.getKey();
                    Integer value = entry.getValue();
                    System.out.printf("%s: %d%n", mat, value);
                });
    }
}
