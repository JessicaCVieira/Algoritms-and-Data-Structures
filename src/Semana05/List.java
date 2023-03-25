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

    //está certo
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

    //está certo
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

    //tá errado
    public boolean removeLast(Item item){
       if(isEmpty()) return false; 

        Node last = null; 
        Node node = first; 
        Node lastOccurNode = null; 

        while(node != null){
            if(node.item.equals(item)){
                lastOccurNode = node; 
            }
            last = node; 
            node = node.next; 

            if(node != null && node.next == null && lastOccurNode != null) break; 

        }

        if(lastOccurNode == null){
            return false; 
        }

        if(lastOccurNode == first){
            first = first.next; 
        }else{
            last.next = lastOccurNode.next; 
        }

        s--;
        return false; 
    } 	

    //está certo
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
        Node prev = null; 

        public boolean hasNext(){
            return node != null; 
        }

        public Item next(){
            if(!hasNext()) throw new IllegalStateException("Não existe nenhum item"); 
            prev = node; 
            Item item = node.item; 
            node = node.next; 
            return item; 
        }

        public boolean hasPrev(){
            return prev != null; 
        }

        public Item prev(){
            if(!hasPrev()) throw new IllegalStateException("Não existe nenhum item");

            node = prev; 
            prev = null; 
            Item item = node.item; 
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

