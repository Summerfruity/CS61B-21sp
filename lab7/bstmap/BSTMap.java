package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{

    private BSTNode root;

    /** Nested class*/
    private class BSTNode{
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;
        private int size;

        /** Node constructor */
        public BSTNode(K key, V value){
            this.value = value;
            this.key = key;
            this.size = 1;
        }
    }

    /** Removes all the mappings from this map. */
    @Override
    public void clear(){
        root = null;
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        return get(key) != null;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key){
        return get(root, key);
    }

    /** helper for get */
    private V get(BSTNode node, K key){
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            return get(node.left, key);
        }
        else if(cmp == 0){
            return node.value;
        }
        else {
            return get(node.right, key);
        }
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        return root.size;
    }

    /** Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value){
        put(root, key, value);
    }

    /** helper for put */
    private void put(BSTNode n, K key, V value){
        int cmp = key.compareTo(n.key);
        if (cmp < 0){
            if (n.left == null){
                n.left = new BSTNode(key, value);
            }
            else {
                put(n.left, key, value);
            }
        }
        else if(cmp == 0){
            return;
        }
        else {
            if (n.right == null){
                n.right = new BSTNode(key, value);
            }
            else {
                put(n.right, key, value);
            }
        }

    }

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    /** Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    /** Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    @Override
    public Iterator<K> iterator(){
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    public void printInOrder(){
        printNode(root);
    }

    /** helper for print */
    private void printNode(BSTNode n){
        if (n==null){
            return;
        }
        else {
            printNode(n.left);
            System.out.print(n.key + "," + n.value);
            System.out.print(" ");
            printNode(n.right);
        }
    }
}
