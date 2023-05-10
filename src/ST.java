//esta semana min max put get

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ST<Key extends Comparable<Key>, Value> {

    private Node root; 

    private class Node{
        Key key; 
        Value val; 
        Node left, right; 
        int size; 

        Node(Key k, Value v){
            key = k; 
            val = v; 
        }
    }


    // Initialise an empty ordered symbol table
    public ST(){
        //root = null -> rever 
    }

    // Put the key-value pair into this table
    public void put(Key key, Value val){
        root = put(root, key, val); 
    }

    private Node put(Node x, Key key, Value val){
        if(x == null)
            return new Node(key, val); 

        int cmp = key.compareTo(x.key);

        if(cmp == 0)
            x.val = val; 
        else if(cmp < 0) 
            x.left = put(x.left, key, val); 
        else 
            x.right = put(x.right, key, val); 

        return x; 
    }

    // // Get the value paired with key (or null)
    // //iterativo
    // public Value geti(Key key){
    //     Node x = root; 
    //     while(x != null){
    //         int cmp = key.compareTo(x.key); 
    //         if(cmp == 0) return x.val;
    //         else if(cmp < 0) 
    //             x = x.left; 
    //         else 
    //             x = x.right; 
    //     }
    //     return null; 
    // }

    // Get the value paired with key (or null)
    //versão recursiva
    public Value get(Key key){
        return get(root, key); 
    }

    private Value get(Node x, Key k){
        //critério de paragem (n nos podemos esquecer de para a recursão)
        if(x == null) return null; 
        //caso recursivo -> avançar pela árvore
        int cmp = k.compareTo(x.key);
        if(cmp == 0) return x.val;
        else if(cmp < 0) 
            return get(x.left, k);  
        else 
            return get(x.right, k); 

    }


    // Remove the pair that has this key
    // public void delete(Key key){

    // }

    // Is there a value paired with the key?
    // public boolean contains(Key key) {

    // }

    // Is this symbol table empty?
    public boolean isEmpty(){
        return root == null;
    }

    // Number of key-value pairs in this table
    // public int size(){

    // }

    // Smallest key
    //tem de ser feito recursivo 
    public Key min(){
        if(root == null)
            throw new NoSuchElementException("A árvore está vazia"); 
        else
            return min(root);  
    }

    private Key min(Node x){
        //avança para a esquerda até x.left == null;
        if(x.left == null) 
            return x.key; 
        else    
            return min(x.left); 
    }

    // Largest key
    //iterador 
    public Key max(){
        if(isEmpty()) 
            throw new NoSuchElementException("A árvore está vazia"); 
        else
            return max(root);

    }

    private Key max(Node x){
        if(x.right == null) 
            return x.key; 
        else    
            return max(x.right); 
    }

    // Largest key less than or equal to key
    // public Key floor(Key key) {

    // }

    // Smallest key greater than or equal to key
    // public Key ceiling(Key key) {

    // }

    // Number of keys less than key
    // public int rank(Key key) {

    // }

    // Get a key of rank k
    // public Key select(int k) {

    // }

    // Delete the pair with the smallest key
    // public void deleteMin() {

    // }

    // Delete the pair with the largest key
    // public void deleteMax(){

    // }

    // Number of keys in [lo, hi]
    // public int size(Key lo, Key hi) {

    // }

    // Keys in [lo, hi] in sorted order
    // public Iterable<Key> keys(Key lo, Key hi) {

    // }

    // All keys in the table, in sorted order
    // public Iterable<Key> keys() {

    // }

    //testar
    // public static void main(String[] args) { 
    //     //output:
    //     ST<String, Integer> st = new ST<String, Integer>();
    //     Scanner sc = new Scanner(System.in);
    //     for (int i = 0; sc.hasNext(); i++) {
    //         String key = sc.next();
    //         st.put(key, i);
    //     }
    //     for (String s : st.keys())
    //         System.out.println(s + " " + st.get(s));
    //     }

    //testar semana 10
    public static void main(String[] args){
        ST<String, Integer> st = new ST<String, Integer>();

        st.put("a", 1); 
        st.put("b", 2); 
        st.put("c", 3); 
        
        System.out.println(st.min()); 
        System.out.println(st.max());
    }

}
        

