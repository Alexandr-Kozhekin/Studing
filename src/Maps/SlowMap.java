package Maps;

import java.util.*;

public class SlowMap<K, V> extends AbstractMap<K, V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value) {

        V oldValue = get(key);

        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }

        return oldValue;
    }

    public V get(Object key) {
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    public void clear() {
        values.clear();
        keys.clear();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {

        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();

        while (ki.hasNext())
            set.add(new MapEntry<K, V>(ki.next(), vi.next()));

        return set;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof MapEntry)) return false;

        MapEntry me = (MapEntry) o;

        return (keys == null ? me.getKey() == null : keys.equals(me.getKey())) &&
                (values == null ? me.getValue() == null : values.equals(me.getValue()));
    }

    @Override
    public int hashCode() {
        return (keys == null ? 0 : keys.hashCode()) ^ (values == null ? 0 : values.hashCode());
    }

}