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

        Node(Key k, Value v, int s){
            key = k; 
            val = v; 
            size = s; 
        }
    }


    // Initialise an empty ordered symbol table
    public ST(){
        root = null; 
    }

    // Put the key-value pair into this table
    public void put(Key key, Value val){
        root = put(root, key, val); 
    }

    private Node put(Node x, Key key, Value val){
        if(x == null)
            return new Node(key, val, 1); 

        int cmp = key.compareTo(x.key);

        if(cmp == 0)
            x.val = val; 
        else if(cmp < 0) 
            x.left = put(x.left, key, val); 
        else 
            x.right = put(x.right, key, val); 

        x.size = 1 + size(x.left) + size(x.right); 

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

    private Value get(Node x, Key key){
        //critério de paragem (n nos podemos esquecer de para a recursão)
        if(x == null) return null; 
        //caso recursivo -> avançar pela árvore
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x.val;
        else if(cmp < 0) 
            return get(x.left, key);  
        else 
            return get(x.right, key); 

    }


    // Remove the pair that has this key
    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("key cannot be null!");
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

        x.size = size(x.left) + size(x.right) + 1;
        return x; 

    }

    // Is there a value paired with the key?
    public boolean contains(Key key) {
        if(key == null) throw new IllegalArgumentException("key cannot be null!");
        return get(key) != null; 
    }

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
            return min(root).key;  
    }

    private Node min(Node x){
        //avança para a esquerda até x.left == null;
        if(x.left == null) 
            return x; 
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
    public int rank(Key key) {
        if(key == null) throw new IllegalArgumentException("Key cannot be null"); 
        return rank(key, root); 
    }

    private int rank (Key key, Node x){
        if (x == null) return 0; 
        int comp =  key.compareTo(x.key);
        if (comp > 0)  return 1 + size(x.left) + rank(key, x.right);
        else if (comp < 0) return rank(key, x.left);
        else return size(x.left);
    }

    // Get a key of rank key
    public Key select(int k) {
        if(k < 0 || k >= size()) throw new IllegalArgumentException("k cannot be null");
        return select(root, k); 
    }

    private Key select (Node x, int k){
        if(x == null) return null; 
        int sizeL = size(x.left); 
        if (sizeL < k) return select(x.right, k -sizeL -1); 
        else if (sizeL > k) return select(x.right, k); 
        else return x.key; 
    }

    // Delete the pair with the smallest key
    //tem de ser feito recursivo
    public void deleteMin() {
        if(isEmpty()) throw new NoSuchElementException("A árvore está vazia");
        root = deleteMin(root);  
    }

    private Node deleteMin(Node x){
        if(x.left == null) return x.right; 
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1; 
        return x;
    }

    // Delete the pair with the largest key
    //pode ser feito sem recursivo
    public void deleteMax(){
        if(isEmpty()) throw new NoSuchElementException("A árvore está vazia"); 
        root = deleteMax(root);
    }

    private Node deleteMax (Node x){
        if (x.right == null) return x.left; 
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // Number of keys in [lo, hi]
    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("Lo cannot be null");
        if (hi == null) throw new IllegalArgumentException("Hi cannot be null");

        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        if (lo.compareTo(hi) > 0) return 0;
        else return rank(hi) - rank(lo);
    }

    //Keys in [lo, hi] in sorted order
    public Iterable<Key> keys(Key lo, Key hi) {

        if (lo == null) throw new IllegalArgumentException("Low cannot be null!"); 
        if (hi == null) throw new IllegalArgumentException("Low cannot be null!");
        
        Queue<Key> queue = new Queue<Key>(); 
        keys(root, queue, lo, hi); 
        return queue; 
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if (x == null) return; 
        int compLow = lo.compareTo(x.key); 
        int compHi = hi.compareTo(x.key); 
        if(compLow < 0) keys(x.left, queue, lo, hi); 
        if(compLow <= 0 && compHi >= 0) queue.enqueue(x.key);
        if(compHi > 0) keys(x.right, queue, lo, hi); 
    }

    // All keys in the table, in sorted order
    public Iterable<Key> keys() {
        return keys(min(), max()); 
    }

    //para vizualizar a arvore
    //print all (key, val) in the tree in ascending order
    public String toString(){
        return toString(root); 
    }

    private String toString(Node x){
        //stop criteria
        if( x == null) return ""; 
        //recursive
        return toString(x.left) + " (" + x.key + " , " + x.val + ") " + toString(x.right);  
    }


    //testar
    public static void main1(String[] args) { 
        //output:
        ST<String, Integer> st = new ST<String, Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        for (int i = 0; i < n; i++) {
            String key = sc.next();
            st.put(key, i);
        }
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
        }

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

        System.out.println(st.toString()); 
    
        //get
        //se existir
        System.out.print("Get:"); 
        System.out.println(st.get("a")); 
        //tem de dar 4
        //se não existir 
        System.out.print("Get:"); 
        System.out.println(st.get("z"));

        //delete
        System.out.print("antes:");
        System.out.println(st.toString()); 
        st.delete("m");  
        System.out.print("depois:"); 
        System.out.println(st.toString()); 

        //contains
        //se existir 
        System.out.print("Contains:"); 
        System.out.println(st.contains("a"));
        //se não existir 
        System.out.print("Contains:"); 
        System.out.println(st.contains("z"));

        //isEmpty
        System.out.print("isEmpty:"); 
        System.out.println(st.isEmpty());

        //size -> está errado (era suposto dar 7 deu 5)
        System.out.print("size:"); 
        System.out.println(st.size());

        //Min e max: 
        System.out.print("Min:"); 
        System.out.println(st.min()); 
        System.out.print("Max:"); 
        System.out.println(st.max());

        //Floor
        System.out.print("Floor:"); 
        System.out.println(st.floor("g")); 

        //Ceiling
        System.out.print("Ceiling:"); 
        System.out.println(st.ceiling("q"));

        //rank
        System.out.print("Rank:"); 
        System.out.println(st.ceiling("q"));

        //select
        System.out.print("select:"); 
        System.out.println(st.select(4));

        //delete min
        System.out.print("antes:"); 
        System.out.println(st.toString()); 
        st.deleteMin();  
        System.out.print("depois:"); 
        System.out.println(st.toString()); 

        //delete max
        System.out.print("antes:"); 
        System.out.println(st.toString()); 
        st.deleteMax();  
        System.out.print("depois:"); 
        System.out.println(st.toString()); 

        //size lo hi
        System.out.print("size:"); 
        System.out.println(st.size("c", "s"));
        
    }

}
        

