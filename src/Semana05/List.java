package Semana05;

import java.util.Iterator;
import java.util.Scanner;

public class List<Item> implements Iterable<Item>{
    
    private Node first, last; 
    private class Node{
        //TODO
    }


    public List() {

    }			

    public void add(Item item) {
        //mt parecido c o enqueue
        //TODO pensar no caso geral 
        // TODO corrigir para os casos críticos 
        // e se a lista estier fazia 
        //e se for o primeiro elemento 
        // e se for o ultimo 
        // e se estiver cheia 
        //n esquecer de fazer a ligação dos nodes 
    }

    public boolean removeFirst(Item item){
        //comparar items usar equals; 

    } 	

    public boolean removeLast(Item item){

    } 	

    public boolean removeAll(Item item){

    }
    
    public boolean isEmpty() {

    }	

    public boolean contains(Item item){

    } 	

    public int size() {

    }		

    public Iterator<Item> iterator(){
        return new ListIterator(); 
    }	

    private class ListIterator implements Iterator<Item>{

        public boolean hasNext(){
            return false; 
        }

        //guardar o valor e andar com o current (current.next)
        public Item next(){
            //guardar o valor e andar com o current (current.next)
            return null; 
        }

    }

    //para testar 

    public static void main (String[] args){
        //TODO criar uma lista
        //inserir itens na lista
        //n é preciso usar o scanner 
        List<String> list = new List<String>(); 
        Scanner sc = new Scanner(System.in); 
        while(true) {
            String word = sc.next(); 
            if(word.equals("end")) 
                break; 
            list.add(word); 
        }
        //testar o remove first (repetir para cada metodo)
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

