package Other;

import java.util.*;

public class CloseSearch {

    public static void main(String[] args) {

        //все штаты
        Set<String> states_needed = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        //радиостанции и их покрытие
        HashMap<String, Set<String>> stations = new HashMap<>();
        stations.put("kone", Set.of("id", "nv", "ut"));
        stations.put("ktwo", Set.of("wa", "id", "mt"));
        stations.put("kthree", Set.of("or", "nv", "ca"));
        stations.put("kfour", Set.of("nv", "ut"));
        stations.put("kfive", Set.of("ca", "az"));

        //итоговый набор станций
        Set<String> final_stations = new HashSet<>();

        while (!states_needed.isEmpty()) {
            //станция которая обслуживает больше всего штатов
            Set<String> best_stations = new HashSet<>();
            //содердит все штаты, обслуживаемые лучшей станцией
            Set<String> states_covered = new HashSet<>();

            for (Map.Entry<String, Set<String>> cov : stations.entrySet()) {
                //пересечение множеств
                //множество штатов не входящих в покрытие, которые поерываются текущей станцией
                Set<String> covered = new HashSet<>(states_needed);
                covered.retainAll(cov.getValue());

                if (covered.size() > states_covered.size()) {
                    best_stations.add(cov.getKey());
                    states_covered.addAll(covered);
                }
            }

            states_needed.removeAll(states_covered);
            final_stations.addAll(best_stations);
        }

        for(String s : final_stations) {
            System.out.println(s);
        }

    }

}