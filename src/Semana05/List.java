package Semana05;

import java.util.Iterator;
import java.util.Scanner;

public class List<Item> implements Iterable<Item>{
    
    private Node first, last;
    private int s; 

    private class Node{
        Item item; 
        Node next; 
        Node prev; 
    }


    public List() {
        first = null; 
        last = null; 
        s = 0; 
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
        s++; 
    }

    public boolean removeFirst(Item item){
        if(!isEmpty()){
            Node node = first; 
            while(node != null){
                if(node.item.equals(item)){
                    if(node == first){
                        first = first.next; 
                        first.prev = null;  
                    }else if(node == last){
                        last = last.prev; 
                        last.next = null; 
                    }else{
                        node.prev.next = node.next; 
                        node.next.prev = node.prev; 
                    }
                    s--; 
                    return true; 
                }
                node = node.next; 
            }
        }
        return false; 
    //falta a exceção para quando só tem 1 elemento;
    } 	

    public boolean removeLast(Item item){
       if(!isEmpty()){
            Node node = last; 
            while(node != null){
                if(node.item.equals(item)){
                    if(node == last){
                        last = last.prev; 
                        last.next = null; 
                    }else if (node == first){
                        first = first.next; 
                        first.prev = null; 
                    }else{
                        node.prev.next = node.prev; //n sei se está certo
                        node.next.prev = node.next; //n sei se esta certo 
                    }
                    s--; 
                    return true; 
                }
                node = node.prev; 
            }
        }
        return false; 
        //falta a excessão de quando só tem 1 elemento
    } 	

    public boolean removeAll(Item item){

        //TODO-> REFAZER

        int count = 0; //indica o nº de vezes que o item aparece na lista, e que vai ser retirado
        if(!isEmpty()){
            Node node = first; 
            while(node != null){
                if(node.item.equals(item)){
                    if(node == first){
                        first = first.next; 
                        first.prev = null;  
                    }else if(node == last){
                        last = last.prev; 
                        last.next = null; 
                    }else{
                        node.prev.next = node.next; 
                        node.next.prev = node.prev; 
                    }
                    s = s - count; //vai retirar o nº de vezes que aquele elemento aparece na lista logo n é -- 
                    return true; 
                }
                node = node.next; 
            }
        }
        return false; 
    //falta a exceção para quando só tem 1 elemento;
    } 	
    
    public boolean isEmpty() {
        return s==0; 
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
        return s; 
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
            if(!hasNext()) throw new IllegalStateException("Não existe nenhum item"); 
            Item item = node.item; 
            node = node.next; 
            return item; 
        }

        public boolean hasPrev(){
            return node != null; 
        }

        public Item prev(){
            if(!hasPrev()) throw new IllegalStateException("Não existe nenhum item");
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
        //Remove first
        System.out.println("_____Remove First_____");
        System.out.println("Que palavra quer remover?"); 
        String toRemoveFirst = sc.next(); 
        list.removeFirst(toRemoveFirst); 
        
        System.out.print("Lista agora: ");
        
        for(String item : list)
            System.out.print(item + " "); 
        System.out.println();

        //Remove last 
        System.out.println("_____Remove Last_____");

        System.out.println("Que palavra quer remover?"); 
        String toRemoveLast = sc.next(); 
        list.removeLast(toRemoveLast); 
        
        System.out.print("Lista agora: ");
        
        for(String item : list)
            System.out.print(item + " "); 
        System.out.println();

        //Remove All
        System.out.println("_____Remove All_____");

        System.out.println("Que palavra quer remover?"); 
        String toRemoveAll = sc.next(); 
        list.removeAll(toRemoveAll); 
        
        System.out.print("Lista agora: ");
        
        for(String item : list)
            System.out.print(item + " "); 
        System.out.println(); 

    }
}

