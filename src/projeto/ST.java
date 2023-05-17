package projeto;
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

        //x.size =

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
    public void delete(Key key){
        root = delete(root, key); 
    }

    //está como o da prof rever o erro 
    private Node delete(Node x, Key key){
        if (x == null) return null; 
        int comp = key.compareTo(x.key); 
        if(comp < 0)
            x.left = delete(x.left, key); 
        else if (comp > 0)
            x.right = delete(x.right, key); 
        else{
            //tem 2 filhos
            if (x.right == null) return x.left; 
            if(x.left == null) return x.right; 
            Node temp = x; 
            x = min(temp.right); 
            x.right = deleteMin(temp.right); 
            x.left = temp.left; 
        }

        //x.size = 
        return x; 

    }
    // Is there a value paired with the key?
    // public boolean contains(Key key) {

    // }

    // Is this symbol table empty?
    public boolean isEmpty(){
        return root == null;
    }

    // Number of key-value pairs in this table
    public int size(){
        return size(root); 
    }

    private int size(Node x){
        if(x == null) return 0; 
        else return x.size; 
    }
    // Smallest key 
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
    public Key floor(Key key) {
        return floor(root, key); 
    }

    private Key floor (Node x, Key key){
        if(x == null) return null; 
        int comp = key.compareTo(x.key); 
        if(comp < 0){
            return floor(x.left, key); 
        }else if( comp == 0){
            return x.key; 
        //comp > 0
        }else{
            Key aux = floor (x.right, key); 
            if(aux == null){
                return x.key; 
            }else{
                return aux; 
            }
        }
    }

    // Smallest key greater than or equal to key
    public Key ceiling(Key key) {
        return ceiling(root, key); 
    }

    private Key ceiling(Node x, Key key){
        if(x == null) return null; 
        int comp = key.compareTo(x.key); 
        if(comp > 0){
            return floor(x.left, key); 
        }else if( comp == 0){
            return x.key; 
        //comp < 0
        }else{
            Key aux = floor (x.left, key); 
            if(aux == null){
                return x.key; 
            }else{
                return aux; 
            }
        }
    }

    // Number of keys less than key
    // public int rank(Key key) {

    // }

    // Get a key of rank k
    // public Key select(int k) {

    // }

    // Delete the pair with the smallest key
    //tem de ser feito recursivo
    public void deleteMin() {
        if(isEmpty()) throw new NoSuchElementException("A árvore está vazia");
        root = deleteMin(root); 
        Queue queue = new Queue();  
    }

    private deleteMin(){
        if()
    }

    // Delete the pair with the largest key
    //pode ser feito sem recursivo
    public void deleteMax(){
        if(isEmpty()) throw new NoSuchElementException("A árvore está vazia"); 
        else return delete(ST.max());
    }

    // Number of keys in [lo, hi]
    // public int size(Key lo, Key hi) {

    // }

    // Keys in [lo, hi] in sorted order
    // public Iterable<Key> keys(Key lo, Key hi) {

        //implementar as keys do lab 4 ou a lista do lab 5

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

        st.put("s", 1); 
        st.put("e", 2); 
        st.put("x", 3); 
        st.put("a", 4); 
        st.put("r", 5); 
        st.put("c", 6);
        st.put("h", 7); 
        st.put("m", 8); 
    
        
        System.out.print("Min:"); 
        System.out.println(st.min()); 
        System.out.print("Max:"); 
        System.out.println(st.max());
        System.out.print("Floor:"); 
        System.out.println(st.floor("g")); 
        System.out.print("Ceiling:"); 
        System.out.println(st.ceiling("q"));
        System.out.print("Rank:"); 
        System.out.print("size:"); 
        System.out.println(st.size());
        
    }

}
        

