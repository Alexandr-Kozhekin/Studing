package Stack;

import java.util.*;

public class Task {

    public static void main(String[] args) {

//        String value = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
//
//        Task.outputChars(value);

        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        hashMap.put(5, 5);
        hashMap.put(4, 4);
        hashMap.put(3, 3);
        hashMap.put(2, 2);
        hashMap.put(1, 1);

        System.out.println(hashMap);

        List<Integer> hashKeys = new ArrayList<>();

        for(int i = 1; i <= hashMap.size(); i++)
            hashKeys.add(hashMap.get(i));

        System.out.println(hashKeys);

        for(int i = hashKeys.size(); i >= 1; i--) {
            linkedHashMap.put(hashKeys.get(i-1), hashKeys.get(i-1));
        }

        for(int i = hashKeys.size(); i >= 1; i--) {
            hashSet.add(hashKeys.get(i-1));
        }

        for(int i = hashKeys.size(); i >= 1; i--) {
            linkedHashSet.add(hashKeys.get(i-1));
        }

        System.out.println("linkedHashMap: " + linkedHashMap);
        System.out.println("hashSet: " + hashSet);
        System.out.println("linkedHashSet: " + linkedHashSet);

    }

    public static void outputChars(String value) {

        Stack<Character> returned = new Stack<Character>();

        for(int i = 0; i < value.length(); i++) {

            if(value.charAt(i) == '+') {
                returned.push(value.charAt(i+1));
            } else if(value.charAt(i) == '-') {
                System.out.print(returned.peek());
                returned.pop();
            }
        }

    }

}
