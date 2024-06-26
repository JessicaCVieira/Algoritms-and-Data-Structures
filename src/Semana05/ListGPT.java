package Semana05;

import java.util.Iterator; 
import java.util.Scanner;

public class ListGPT<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public ListGPT() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public boolean removeFirst(Item item) {
        if (isEmpty()) {
            return false;
        }
        if (first.item.equals(item)) {
            first = first.next;
            size--;
            return true;
        }
        Node<Item> current = first;
        while (current.next != null && !current.next.item.equals(item)) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    public boolean removeLast(Item item) {
        if (isEmpty()) {
            return false;
        }
        if (last.item.equals(item)) {
            if (size == 1) {
                first = null;
                last = null;
            } else {
                Node<Item> current = first;
                while (current.next != last) {
                    current = current.next;
                }
                current.next = null;
                last = current;
            }
            size--;
            return true;
        }
        Node<Item> current = first;
        while (current.next != null && !current.next.item.equals(item)) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        if (current.next == last) {
            current.next = null;
            last = current;
        } else {
            current.next = current.next.next;
        }
        size--;
        return true;
    }

    public boolean removeAll(Item item) {
        boolean removed = false;
        while (removeFirst(item)) {
            removed = true;
        }
        return removed;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Item item) {
        Node<Item> current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    private class ListIterator<Item> implements Iterator<Item> {
        
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    
    public static void main (String[] args){
    
        ListGPT<String> list = new ListGPT<String>(); 
        Scanner sc = new Scanner(System.in); 
        sc.close(); 
        while(true) {
            String word = sc.next(); 
            if(word.equals("end")) 
                break; 
            list.add(word); 
        }
        //remove first apperance
        System.out.println("Que palavra quer remover?"); 
        String toRemoveFirst = sc.next(); 
        list.removeFirst(toRemoveFirst); 
        //imprimir a lista
        System.out.print("Lista agora: ");
        //for each (para cada item dessa lista)
        for(String item : list)
            System.out.print(item + " "); 
        System.out.println(); //imprime uma linha vazia

        //remove last 
        System.out.println("Que palavra quer remover?"); 
        String toRemoveLast = sc.next(); 
        list.removeLast(toRemoveLast); 
        //imprimir a lista
        System.out.print("Lista agora: ");
        //for each (para cada item dessa lista)
        for(String item : list)
            System.out.print(item + " "); 
        System.out.println(); //imprime uma linha vazia

        //Remove all
        System.out.println("Que palavra quer remover?"); 
        String toRemoveAll = sc.next(); 
        list.removeAll(toRemoveAll); 
        //imprimir a lista
        System.out.print("Lista agora: ");
        //for each (para cada item dessa lista)
        for(String item : list)
            System.out.print(item + " "); 
        System.out.println(); //imprime uma linha vazia
    }

}

