package Hashtable;

import java.util.Arrays;

public class HashMap<K, V> {
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size;
    private float loadFactor;

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("cap should greater than 0");
        }
        this.array = (Node<K, V>[])(new Node[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        return key.hashCode() & 0x7FFFFFFF;
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
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

    private boolean equalsValue(V v1, V v2) {
        if (v1 == null && v2 == null) {
            return true;
        }

        if (v1 == null || v2 == null) {
            return false;
        }

        return v1.equals(v2);
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> node : array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public V put(K key,V value) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                V res = node.value;
                node.value = value;
                return res;
            }
            node = node.next;
        }
        Node<K, V> head = array[index];
        Node<K, V> newHead = new Node(key, value);
        newHead.next = head;
        array[index] = newHead;
        size++;
        if (needRehashing()) {
            rehashing();
        }
        return null;
    }

    public V get(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    private boolean needRehashing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void rehashing() {
        Node<K, V>[] newArray = (Node<K,V>[])(new Node[array.length * 2]);
        transfer(newArray);
        array = newArray;
    }

    private void transfer(Node<K,V>[] newArray) {
        Node<K, V>[] src = array;
        for (Node<K, V> node : src) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = getIndex(node.key);
                node.next = newArray[index];
                newArray[index] = node;
                node = next;
            }
        }
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> prev = array[index];
        Node<K, V> node = prev;
        while (node != null) {
            Node<K, V> next = node.next;
            if (equalsKey(node.key, key)) {
                if (prev == node) {
                    array[index] = next;
                }
                else {
                    prev.next = next;
                }
                return node.value;
            }
            prev = node;
            node = next;
        }
        return null;
    }
}
