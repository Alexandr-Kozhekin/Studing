package Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        SimpleHashMap<String, String> shMap = new SimpleHashMap<>();

        hashMap.put("CAMEROON", List.of("X", "Y", "Z"));
        hashMap.put("CAMEROON", List.of("C", "V", "B"));
        hashMap.put("CAMEROON", List.of("F", "G", "W"));
//        shMap.put("CAPE VERDE","Algiers");
//        shMap.put("COMOROS","Moroni");
//        shMap.put("CENTRAL AFRICAN REPUBLIC","Bangui");
//        shMap.put("BOTSWANA","Gaberone");
//        shMap.put("EGYPT","Cairo");

        Test test = new Test();

        test.startedTest(shMap);

    }
}

class Test {

    public void startedTest(Map<String, String> map) {

        System.out.println(map.getClass().getSimpleName());

        printKeys(map);

        System.out.print("Values: ");
        System.out.println(map.values());

        System.out.println(map);

        System.out.println("map.containsKey(CAPE VERDE): " + map.containsKey("CAPE VERDE"));
        System.out.println("map.get(CAMEROON): " + map.get("CAMEROON"));
        System.out.println("map.containsValue(Algiers)" + map.containsValue("Algiers"));

        String key = map.keySet().iterator().next();

        System.out.println("First key in map: " + key);

        map.remove(key);

        printKeys(map);

        map.clear();

        System.out.println("map.isEmpty(): " + map.isEmpty());
//
//        map.put("CAMEROON","Yaounde");
//        map.put("CHAD","N'djamena");
//        map.put("CONGO","Brazzaville");
//        map.put("CAPE VERDE","Algiers");
//        map.put("COMOROS","Moroni");
//        map.put("CENTRAL AFRICAN REPUBLIC","Bangui");
//        map.put("BOTSWANA","Gaberone");
//        map.put("EGYPT","Cairo");

        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());

    }

    public static void printKeys(Map<String, String> map) {
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: ");
        System.out.println(map.keySet());
    }
}
