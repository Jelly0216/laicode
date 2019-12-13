package Practice;

public class MyHashMap<K, V> {
    public static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static final int DEFAULT_CAPACITY = 10;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] array;
    private int size;
    private float loadFactor;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity, float loadFactor) {
        array = (Entry<K, V>[])(new Entry[capacity]);
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0X7FFFFFFF;
    }

    private int getIndex(int hash) {
        return hash % array.length;
    }

    private boolean equalsKey(K k1, K k2) {
        if (k1 == null && k2 == null) {
            return true;
        }

        if (k1 == null || k2 == null) {
            return false;
        }

        return k1.equals(k2);
    }
    public V get(K key) {
        int hash = getHash(key);
        int hashIndex = getIndex(hash);
        Entry<K, V> currEntry = array[hashIndex];
        while (currEntry != null) {
            if (equalsKey(currEntry.key, key)) {
                return currEntry.value;
            }
            currEntry = currEntry.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int hash = getHash(key);
        int hashIndex = getIndex(hash);
        Entry<K, V> currEntry = array[hashIndex];
        while (currEntry != null) {
            if (equalsKey(currEntry.key, key)) {
                V temp = currEntry.value;
                currEntry.value = value;
                return temp;
            }
            currEntry = currEntry.next;
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = array[hashIndex];
        array[hashIndex] = newEntry;
        size++;
        if (needRehasing()) {
            reshaing();
        }
        return null;
    }

    private boolean needRehasing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void reshaing() {
        Entry<K, V>[] newArray = (Entry<K, V>[])(new Entry[array.length * 2]);
        for (Entry<K, V> entry : array) {
            while (entry != null) {
                int hash = getHash(entry.key);
                int hashIndex = getIndex(hash);
                Entry<K, V> newEntry = new Entry<>(entry.key, entry.value);
                newEntry.next = newArray[hashIndex];
                newArray[hashIndex] = newEntry;
                entry = entry.next;
            }
        }
    }

    private V remove(K key) {
        int hash = getHash(key);
        int hashIndex = getIndex(hash);
        Entry<K, V> currEntry = array[hashIndex];
        Entry<K, V> prev = null;
        while (currEntry != null) {
            if (equalsKey(currEntry.key, key)) {
                prev.next = currEntry.next;
                size--;
                return currEntry.value;
            }
            prev = currEntry;
            currEntry = currEntry.next;
        }
        return null;
    }

    }
