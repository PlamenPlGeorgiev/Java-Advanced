import java.util.*;

public class _14_DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, TreeSet<String>> typeDragon = new LinkedHashMap<>();
        Map<String, TreeMap<String, Integer>> typeDragonDamage = new TreeMap<>();
        Map<String, TreeMap<String, Integer>> typeDragonHealth = new TreeMap<>();
        Map<String, TreeMap<String, Integer>> typeDragonArmor = new TreeMap<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String type = tokens[0];
            String dragon = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);
            if (!typeDragon.containsKey(type)) {
                typeDragon.put(type, new TreeSet<>());
            }
            typeDragon.get(type).add(dragon);
            if (!typeDragonDamage.containsKey(type)) {
                typeDragonDamage.put(type, new TreeMap<>());
            }
            typeDragonDamage.get(type).put(dragon, damage);
            if (!typeDragonHealth.containsKey(type)) {
                typeDragonHealth.put(type, new TreeMap<>());
            }
            typeDragonHealth.get(type).put(dragon, health);
            if (!typeDragonArmor.containsKey(type)) {
                typeDragonArmor.put(type, new TreeMap<>());
            }
            typeDragonArmor.get(type).put(dragon, armor);
        }
        typeDragon.entrySet().stream()
                .forEach(entry -> {
                    String type = entry.getKey();
                    TreeSet<String> dragons = typeDragon.get(type);
                    double totDamage = 0;
                    double totHealth = 0;
                    double totArmor = 0;
                    for (String dragon : dragons) {
                        totDamage += typeDragonDamage.get(type).get(dragon);
                        totHealth += typeDragonHealth.get(type).get(dragon);
                        totArmor += typeDragonArmor .get(type).get(dragon);
                    }
                    double avgDamage = (totDamage / dragons.size());
                    double avgHealth = (totHealth / dragons.size());
                    double avgArmor = (totArmor / dragons.size());
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);
                    for (String dragon : dragons) {
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                                , dragon
                                , typeDragonDamage.get(type).get(dragon)
                                , typeDragonHealth.get(type).get(dragon)
                                , typeDragonArmor .get(type).get(dragon));
                    }
                });
    }
}