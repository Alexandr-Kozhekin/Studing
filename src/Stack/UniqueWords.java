package Stack;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;


public class UniqueWords {
    public static void main(String[] args) {

        try {

//            String s = String.valueOf(Files.readAllLines(Path.of("/Users/alexandrkozhekin/Studies/" +
//                    "IntaliIDEA/GrokaemAlgoritmi/src/Stack/Stack.java")));

            String text = UniqueWords.readFile("/Users/alexandrkozhekin/Studies/" +
                    "IntaliIDEA/GrokaemAlgoritmi/src/Stack/Stack.java");

//            System.out.println(UniqueWords.getCountVowelsInText(text));
//            System.out.println(UniqueWords.countVowelsOccurrencesInText(text));
//            System.out.println(UniqueWords.countWordsOccurrencesInText(text));
            System.out.println(UniqueWords.countWordsInText(text));
            System.out.println(UniqueWords.allWordsAndPosition(text));

        } catch (IOException e) {
            System.out.println("Файл не нейден!");
        }

    }

    public static int getCountVowelsInText(String text) {

        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'));

        int counter = 0;

        for(String x : List.of(text.split("\\W+"))) {
            for(char y : x.toCharArray()) {
                if(vowels.contains(y)) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static HashMap<Character, Integer> countVowelsOccurrencesInText(String text) {

        HashMap<Character, Integer> vowelsCounter = new HashMap<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'));

        for(String x : List.of(text.split("\\W+"))) {
            for(char y : x.toCharArray()) {
                if(vowels.contains(y)) {
                    Integer freq = vowelsCounter.get(y);
                    vowelsCounter.put(y, freq == null ? 1 : freq+1);
                }
            }
        }

        return vowelsCounter;
    }

    public static HashMap<String, Integer> countWordsOccurrencesInText(String text) {

        HashMap<String, Integer> wordsCounter = new HashMap<>();

        for(String x : List.of(text.split("\\W+"))) {
            Integer freq = wordsCounter.get(x);
            wordsCounter.put(x, freq == null ? 1 : freq+1);
        }

        ArrayList<String> words = new ArrayList<>(wordsCounter.keySet());

        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);

        System.out.println(words);

        return wordsCounter;
    }

    public static Set<Words> countWordsInText(String text) {

        Set<Words> wordsCounter = new HashSet<>();

        for(String s : List.of(text.split("\\W+"))) {
            Words x = new Words(s);
            for(Words words : wordsCounter){
                if(words.getWord().equals(s)) {
                    words.setCounter(words.getCounter()+1);
                }
            }

            wordsCounter.add(x);
        }

        return wordsCounter;
    }

    public static Map<String, ArrayList<Integer>> allWordsAndPosition(String text) {

        Map<String, ArrayList<Integer>> allWords = new HashMap<>();
        int counter = 0;

        System.out.println(text);

        for(String x : List.of(text.split("\\W+"))) {

            counter++;

            if(allWords.containsKey(x)) {
                allWords.get(x).add(counter);
            } else {
                allWords.put(x, new ArrayList<>(List.of(counter)));
            }
        }

        return allWords;
    }

    public static String readFile(String fileName) throws IOException {

        FileReader reader = new FileReader(fileName);

        StringBuilder builder = new StringBuilder();

        char[] buf = new char[256];
        int c;

        while((c = reader.read(buf)) > 0) {

            if(c < 256){
                buf = Arrays.copyOf(buf, c);
            }

            builder.append(buf);
        }

        return builder.toString();
    }
}
