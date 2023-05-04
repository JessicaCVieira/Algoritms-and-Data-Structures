package Semana09;


//Agora vemos o last 
//o primeiro aponta para nulo 
//o next vai apontar para trás
public class QueueLast<T> {

    private Node last = null; 

    private class Node{
        T item; 
        Node next; 

        //construtor do nó
        Node(T item, Node next){
            this.item = item; 
            this.next = next; 
        }
    }

    //já não é recursivo 
    public void enqueue(T item){
        last = new Node(item, last);  
    }

    
    //recursivo
    //vai sair o primeiro (first que não existe)
    public void dequeue(){
       last = dequeue(last);  
    }

    private Node dequeue(Node f){
        if(f.next == null){ //É o primeiro Nó? 
            return null; 
        }else{
            f.next = dequeue(f.next); //vai avançar para o vizinho
            return f; 
        }
    }

    //recursivo vai devolver o item quando chegar ao null 
    public T first(){
        return first(last); 
    }

    private T first(Node f){
        if(f.next == null){ //É o primeiro Nó? 
            return f.item; 
        }else{
            return first(f.next); //pergunta que faz para o vizinho: Você é o primeiro
        }
    }

    public boolean isEmpty(){
        return last == null; 
    }

    //recursivo                                            Nas árvores tudo é recursivo por isso é que estamos a fazer isto
    public int size(){
        return size(last); 
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
        return toString(last); 
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

