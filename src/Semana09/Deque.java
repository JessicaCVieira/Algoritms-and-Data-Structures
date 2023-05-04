package Semana09;

import java.util.NoSuchElementException;

public class Deque<Item> {

    private Node first = null; 

    private class Node{
        Item item; 
        Node next; 

        //construtor do nó
        Node(Item item, Node next){
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
        first = new Node(item, first); 
    } 

    // pushRight é recursiva 
    public void pushRight(Item item){ // Add an item to the right end
        first = pushRight(first, item);
    } 

    private Node pushRight(Node d, Item item){ // Recursive auxiliary of pushRight
        if(d == null){
            return new Node(item, null); 
        }else{
            d.next = pushRight(d.next, item);
            return d; 
        }
        
    } 

    public void popLeft(){ // Remove item from the left end
        if(first == null)
            throw new IllegalStateException("Error: Empty Deque");
        else
            first = first.next;
    } 

    //popRight é recursiva 
    public void popRight(){ // Remove item from the right end
        first = popRight(first); 
    } 

    private Node popRight(Node d){ // Recursive auxiliary of popRight
        if(d.next == null){
            return  null; 
        }else{
            d.next = popRight(d.next); 
            return d;
        }

    } 

    public Item left(){ // Get the item on the left end
        if(isEmpty())
            throw new NoSuchElementException("Error: Empty Deque!");
        else
            return first.item; 
    } 

    //right recursiva
    public Item right(){ // Get the item on the right end
        return right(first);
    } 

    private Item right(Node d){ // Recursive auxiliary of right
        if(d.next == null){
            return d.item; 
        }else{
            return right(d.next);
        }
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
            return f.item + " " + toString(f.next); 

    }

    public static void main (String[] args){
        //Add a b c d 
        //Remove a b c 
        //Add e f g 

        Deque<String> q = new Deque<>(); 
        q.pushRight("a");
        q.pushLeft("b");
        q.pushLeft("c");
        q.pushRight("d");

        System.out.println(q);

        q.popLeft();
        q.popRight();
        q.popLeft();

        System.out.println(q);

        q.pushLeft("e");
        q.pushRight("f");
        q.pushLeft("g");

        System.out.println(q);

    }
    
}
