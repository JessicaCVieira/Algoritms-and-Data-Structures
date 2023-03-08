package Semana04

importjava.util.iterator; 

public class Queue<Item> implements Iterable<Item>{
    
    Node first, last; 

    private class Node{
        Item item; 
        Node next; 
    }

    //create an em
    public Queue(){
        first = null; 
        last = null; 
    }

    public void enqueue(Item item){
        //caso problemático, fila vazia 

    }

    public Item dequeue (){
        //caso critico ser o ultimo elemento
    }

    public boolean isEmpty(){

    }

    public int size(){

    }

    //suport iteration
    @Override
    public Iterator<Item> iterator(){
        return new QueueIterator(); 
    }

    private class QueueIterator implements Iterator<Item> {
        



    }

}
