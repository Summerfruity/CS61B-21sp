package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BSTNode root;

    /** Nested class */
    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;
        private int size;

        /** Node constructor */
        public BSTNode(K key, V value) {
            this.value = value;
            this.key = key;
            this.size = 1;
        }
    }

    /** Removes all the mappings from this map. */
    @Override
    public void clear() {
        root = null;
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        return get(root, key);
    }

    /** Helper for get */
    private V get(BSTNode node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp == 0) {
            return node.value;
        } else {
            return get(node.right, key);
        }
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode n) {
        if (n == null) {
            return 0;
        }
        return n.size;
    }

    /** Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        root = put(root, key, value);
    }

    /** Helper for put */
    private BSTNode put(BSTNode n, K key, V value) {
        if (n == null) {
            return new BSTNode(key, value);
        }
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.left = put(n.left, key, value);
        } else if (cmp > 0) {
            n.right = put(n.right, key, value);
        } else {
            n.value = value; // Overwrite value if key exists
        }
        n.size = size(n.left) + size(n.right) + 1;
        return n;
    }

    /** Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    /** Removes the mapping for the specified key from this map if present. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    /** Removes the entry for the specified key only if it is currently mapped to
     * the specified value.
     */
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    public void printInOrder() {
        printNode(root);
    }

    /** Helper for print */
    private void printNode(BSTNode n) {
        if (n == null) {
            return;
        }
        printNode(n.left);
        System.out.println(n.key + " : " + n.value);
        printNode(n.right);
    }
}
