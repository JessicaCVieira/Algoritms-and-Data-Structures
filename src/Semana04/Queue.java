package Semana04;

import java.util.Iterator; 
import java.util.Scanner; 

//Eficiência espacial: Linear

public class Queue<Item> implements Iterable<Item> {
    
    private Node first, last;
    private int s;  
    

    private class Node{
        Item item; 
        Node next; 
    }

    public Queue(){
        first = null; 
        last = null; 
        s = 0; 
    }

    //Eficiência temporal: constante
    public void enqueue(Item item){  
        Node oldLast = last; 
        last = new Node(); 
        last.item = item; 
        last.next = null; 
        if(isEmpty()){
            first = last; 
        }else{
            oldLast.next = last; 
        }
        s++; 
    }

    //Eficiência temporal: constante
    public Item dequeue(){   
        if(isEmpty()) throw new IllegalStateException("The queue is empty"); 
        Item item = first.item; 
        first = first.next; 
        s--; 
        if (isEmpty()) last = null; 
        return item; 
    }

    //Eficiência temporal: constante
    public boolean isEmpty(){ 
        return first == null; 
    }

    //Eficiência temporal: constante
    public int size(){  
       return s; 
    }


    //suport iteration
    @Override
    //Eficiência temporal: linear
    public Iterator<Item> iterator(){
        return new QueueIterator(); 
    }

    private class QueueIterator implements Iterator<Item> {

        Node cur = first; 

        public boolean hasNext(){
            return cur != null; 
        }

        public Item next(){
            if(!hasNext()) throw new IllegalStateException("Não existe nenhum item"); 
            Item item = cur.item; 
            cur = cur.next; 
            return item; 
        }

    }

    public static void main(String[] args){
        Queue<String> queue = new Queue<String> (); 
        Scanner sc = new Scanner (System.in);
        while(true){
            String word = sc.next(); 
            if(word.equals ("end")) break; 
                if(word.equals("-"))
                    System.out.println(queue.dequeue()); 
                else
                    queue.enqueue(word);
        } 
        sc.close(); 
        for(String str: queue){
            System.out.print(str + " ");
        }
    }

}
