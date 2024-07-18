package Maps;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private static final int SIZE = 997;
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {

        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        //Если в bucket нету linkedlista то добавляем
        if(buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        //беркм из bucked linkedlist (новый или уже дабавленный)
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        //берем пару кдюч/значение из входных данных
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        //флаг поиска одинаковых ключей
        boolean found = false;
        //итератор прохода по linkedlist
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();

        //запускаем проход
        while(it.hasNext()) {
            //берем пару из linkedlist
            MapEntry<K, V> iPair = it.next();
            //если ключи входного значения и ключа содержащегося в linkedlist совпадают
            if(iPair.getKey().equals(key)) {
                //сохраняем старое значение
                oldValue = iPair.getValue();
                //сетаем новое знасение на место старого
                it.set(pair);
                //меняем флаг
                found = true;

                break;
            }
        }

        // если ключи разные просто добавляем пару в конец lnkedlist
        if(!found) {
            buckets[index].add(pair);
        }

        //возвращаем сатрое значение согластно доккументации
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;

        if(buckets[index] == null) return null;

        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }

        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {

        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();

        for(LinkedList<MapEntry<K, V>> bucket : buckets) {
            if(bucket == null)
                continue;
            for(MapEntry<K, V> mpair : bucket)
                set.add(mpair);

        }

        return set;
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }
}
