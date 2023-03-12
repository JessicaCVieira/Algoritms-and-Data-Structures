package Semana04;

import java.util.Iterator; 
import java.util.Scanner; 

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
        //caso geral 


        //caso problemático, fila vazia 

        //dizer se cada método é linear etc etc 
    }

    public Item dequeue (){
        //caso critico ser o ultimo elemento
    }

    public boolean isEmpty(){

    }

    public int size(){
        //caso critico vazia

    }

    //suport iteration
    @Override
    public Iterator<Item> iterator(){
        return new QueueIterator(); 
    }

    private class QueueIterator implements Iterator<Item> {

        Node cur = first; 

        public boolean hasNext(){
            //acho que tenho de terminar
            return false; 
        }

        public Item next(){
            //terminar
            return null; 
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
