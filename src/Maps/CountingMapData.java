package Maps;

import java.util.*;

public class CountingMapData extends AbstractMap<String, String> {

    private int size;
    private final static String[] chars = "A B C D E F G H I J K L M N O P Q S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        if(size < 0) this.size = 0;

        this.size = size;
    }

    private static class Entry implements Map.Entry<String, String> {

        String index;

        Entry(String index) {
            this.index = index;
        }

        @Override
        public String getKey() {
            return index ;
        }

        @Override
        public String getValue() {

//            int i = (int) (Math.random() * chars.length);
//
//            if(i % chars.length >= chars.length && i <= 0)
//                return chars[0];

            int q = Integer.parseInt(index);

            return chars[q % chars.length] + q / index.length();
        }

        @Override
        public String setValue(String value) {
            return "";
        }
    }

    @Override
    public Set<Map.Entry<String, String>> entrySet() {

        Set<Map.Entry<String, String>> entries = new LinkedHashSet<>();

        for (int i = 0; i < size; i++)
            entries.add(new Entry("" + i));

        return entries;
    }

}
