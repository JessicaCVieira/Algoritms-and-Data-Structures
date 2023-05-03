package Semana09;

import java.util.NoSuchElementException;

public class Queue<T> {
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

    //recursivo 
    public void enqueue(T item){
        first = enqueue(first, item); 
    }

    private Node enqueue(Node f, T item){
        if(f == null){ //cheguei ao fim 
            return new Node(item, null ); //null pq não tem nenhum vizinho à direita
        }else{
            f.next = enqueue(f.next, item); 
            return f; 
        }
    }

    //quem sai da fila é o primeiro da fila 
    public void dequeue(){
        if(first == null) //ou if isEmpty
            throw new IllegalStateException("Error: Empty Queue!"); 
        else
            first = first.next; 
    }

    //devolve o primeiro item do tipo T da fila 
    public T first(){
        if(isEmpty()) //ou if first == null
            throw new NoSuchElementException("Error: Empty Queue!"); //ou illegal state exception
        else
            return first.item; 
    }

    public boolean isEmpty(){
        return first == null; 
    }

    //recursivo                                            Nas árvores tudo é recursivo por isso é que estamos a fazer isto
    public int size(){
        return size(first); 
    }

    //indica a forma como avançamos 
    private int size(Node f){
        if(f == null)
            return 0; 
        else
            return 1 + size(f.next); 
    }

    //versão recursiva do toString -> pq na arvore é sempre recursiva
    public String toString(){
        return toString(first); 
    }

    private String toString(Node f){
        if(f == null){
            return ""; //retorna a string vazia
        }else{
            return f.item + " " + toString(f.next); 
        }
    }

    public static void main (String[] args){
        //Add a b c d 
        //Remove a b c 
        //Add e f g 

        Queue<String> q = new Queue<>(); 
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
