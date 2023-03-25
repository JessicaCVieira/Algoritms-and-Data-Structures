package Semana05;

import java.util.Iterator;
import java.util.Scanner;

public class List<Item> implements Iterable<Item>{
    
    private Node first, last;
    private int s; 

    private class Node{
        Item item; 
        Node next;
    }


    public List() {
        first = null; 
        last = null; 
        s = 0; 
    }			

    //Add item to the list
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

    //Remove first occurence
    public boolean removeFirst(Item item){
        if(isEmpty()) return false; 

        if(first.item.equals(item)){
            first = first.next; 
            s--; 
            return true; 
        }

        Node node = first; 
        while(node.next != null && !node.next.item.equals(item)){
            node = node.next; 
        }

        if(node.next == null) return false; 

        node.next = node.next.next; 
        s--; 
        return true; 
    }

    //Remove last occurrence
    public boolean removeLast(Item item) {
        if (isEmpty()) return false;
    
        Node prev = null;
        Node node = first;
        Node last = null;
    
        while (node != null) {
            if (node.item.equals(item)) {
                last = node;
            }
            prev = node;
            node = node.next;
        }
    
        if (last == null) return false;
    
        if (last.next == null) {
            prev.next = null;
        } else {
            last.item = last.next.item;
            last.next = last.next.next;
        }
    
        s--;
        return true;
    }
    
    //Remove all items
    public boolean removeAll(Item item){
        boolean removido = false;
        while (removeFirst(item)) {
            removido = true;
        }
        return removido;
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

        public Item next(){
            if(!hasNext()) throw new IllegalStateException("Não existe nenhum item"); 
            Item item = node.item; 
            node = node.next; 
            return item; 
        }
    }

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

