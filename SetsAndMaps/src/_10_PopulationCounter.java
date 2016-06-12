import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by admin on 26.5.2016 г..
 */
public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Long> countryTotal = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Long>> countryTownPopulation = new LinkedHashMap<>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("report")) {
                break;
            }
            String[] tokens = input.split("\\|");
            String town = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);
            if (!countryTotal.containsKey(country)) {
                countryTotal.put(country, (long) 0);
            }
            countryTotal.put(country, countryTotal.get(country) + population);
            if (!countryTownPopulation.containsKey(country)) {
                countryTownPopulation.put(country, new LinkedHashMap<>());
            }
            if (!countryTownPopulation.get(country).containsKey(town)) {
                countryTownPopulation.get(country).put(town, (long) 0);
            }
            countryTownPopulation.get(country).put(town, countryTownPopulation.get(country).get(town) + population);
        }
        countryTotal.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(entry -> {
                    String country = entry.getKey();
                    Long total = entry.getValue();
                    System.out.printf("%s (total population: %d)%n", country, total);
                    countryTownPopulation.get(country).entrySet().stream()
                            .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                            .forEach(entrys -> {
                                String town = entrys.getKey();
                                Long population = entrys.getValue();
                                System.out.printf("=>%s: %d%n", town, population);
                            });
                });
    }
}
