package Semana09;

public class Deque<T> {

    private Node first = null; 

    private class Node{
        T item; 
        Node next; 

        //construtor do nó
        Node(T item, Node next){
            this.item = item; 
            this.next = next; 
        }
    }
    
    public boolean isEmpty(){ // Is the deque empty?
        return first == null; 

    }

    //recursivo
    public int size(){ // Number of items in the deque
        return size(first); 
    } 

    private int size(Node d){ // Recursive auxiliary of size
        if(d == null)
            return 0; 
        else
            return 1 + size(d.next); 
    } 

    public void pushLeft(Item item){ // Add an item to the left end

    } 

    // pushRight é recursiva 
    public void pushRight(Item item){ // Add an item to the right end

    } 

    private Node pushRight(Node d, Item item){ // Recursive auxiliary of pushRight

    } 

    public void popLeft(){ // Remove item from the left end

    } 

    //popRight é recursiva 
    public void popRight(){ // Remove item from the right end

    } 

    private Node popRight(Node d){ // Recursive auxiliary of popRight

    } 

    public Item left(){ // Get the item on the left end

    } 

    //right recursiva
    public Item right(){ // Get the item on the right end

    } 

    private Item right(Node d){ // Recursive auxiliary of right

    } 

    //versão recursiva do toString -> pq na arvore é sempre recursiva
    public String toString(){
        return toString(first); 
    }

    private String toString(Node f){
        if(f == null)
            return ""; 
        //avança até ao primeiro para depois imprimir
        //primeiro avança de depois escreve
        else
            return toString(f.next) + " " + f.item; 

    }

    public static void main (String[] args){
        //Add a b c d 
        //Remove a b c 
        //Add e f g 

        QueueLast<String> q = new QueueLast<>(); 
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");

        System.out.println(q);

        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println(q);

        q.enqueue("e");
        q.enqueue("f");
        q.enqueue("g");

        System.out.println(q);

    }
    
}
