package Semana05;

import java.util.Iterator;
import java.util.Scanner;

public class List<Item> implements Iterable<Item>{
    
    private Node first, last;
    private int n; 

    private class Node{
        //TODO
        Item item; 
        Node next; 
        Node prev; 
    }


    public List() {

    }			

    public void add(Item item) {

        Node node = new Node(); 
        node.item = item; 

        if(first ==  null){
            first = node; 
        }else{
            last.next = node; 
        }
        last = node; 
        n++; 
    }

    public boolean removeFirst(Item item){
        if(!isEmpty()){
            Node node = first; 
            while(node != null){
                if(node.item.equals(item)){
                    if(node == first){
                        first = first.next; 
                        first.prev = null;    // falta definir o prev
                    }else if(node == last){
                        last = last.prev; 
                        last.next = null; 
                    }else{
                        node.prev.next = node.next; 
                        node.next.prev = node.prev; 
                    }
                    return true; 
                }
                node = node.next; 
            }
        }
        return false; 

        //falta a exceção para quando só tem 1 elemento;

    } 	

    public boolean removeLast(Item item){

    } 	

    public boolean removeAll(Item item){

    }
    
    public boolean isEmpty() {

    }	

    public boolean contains(Item item){
        Iterator<Item> it = iterator(); 
        while(it.hasNext()){
            Item itemNode = it.next(); 
            if(itemNode.equals(item)){
                return true; 
            }
        }
        return false; 
    } 	

    public int size() {
        return n; 
    }		

    public Iterator<Item> iterator(){
        return new ListIterator(); 
    }	

    private class ListIterator implements Iterator<Item>{

        Node node = first; 

        public boolean hasNext(){
            return node != null; 
        }

        //guardar o valor e andar com o current (current.next)
        public Item next(){
            Item item = node.item; 
            node = node.next; 
            return item; 
            //guardar o valor e andar com o current (current.next)
        }

        public Item prev(){
            Item item = node.item; 
            node = node.prev; 
            return item; 
        }

    }

    //para testar 

    public static void main (String[] args){
    
        List<String> list = new List<String>(); 
        Scanner sc = new Scanner(System.in); 
        while(true) {
            String word = sc.next(); 
            if(word.equals("end")) 
                break; 
            list.add(word); 
        }
        //repetir para cada metodo
        System.out.println("Que palavra quer remover?"); 
        String toRemoveFirst = sc.next(); 
        list.removeFirst(toRemoveFirst); 
        //imprimir a lista
        System.out.print("Lista agora: ");
        //for each (para cada item dessa lista)
        for(String item : list)
            System.out.print(item + " "); 
        System.out.println(); //imprime uma linha vazia

    }
}

