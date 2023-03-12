package Semana03; 

import java.util.Scanner;

public class ResizingArrayQueueOfStrings {

    private String[] q; 
    private int first, last; 
    private static final int CAPACITY = 8; 

    //create an empty queue
    public ResizingArrayQueueOfStrings(){
        q = new String[CAPACITY]; 
        first = -1; 
        last = -1;     
    } 

    private int next (int i){
        return (i + 1) % q.length; 
    }

    public void enqueue(String item){
        //caso geral: 
        last = next(last); 
        q[last] = item; 

        //Cheia
        if(size() == q.length){
            resize(q.length*2); 
        }
        int next = next(last); 
        q [next] = item; 
        last = next; 

        if (first == -1){
            first = 0; 
        }   

        //vazia: 
        if(isEmpty()) first = last; 
        
    }

    //remove the least recently added item
    public String dequeue(){ 

        //vazia
        if(isEmpty()) throw new IllegalStateException("Empty queue"); 
      
        String item = q[first]; 
        q[first] = null; 

        if(first == last){
            last = -1;
            first = -1; 
        }else{
            first = next(first); 
        }
       
        if(size() > 0 && size() == (q.length/4)) resize (q.length/2); 

        return item; 
    } 

    //is the queue empty?
    public boolean isEmpty(){
        if(first == -1) return true; 
        else return false; 
    }

    //number of items in the queue
    public int size(){
        if(first == -1) return 0; 
        if( first <= last )
            return last - first + 1;
        else
            return last + 1 + q.length - first; 

    } 

    private void resize(int capacity){
        String[] p = new String[capacity]; 
        int a = 0; 
        for(int i = 0; i < size(); i++){
            p[a] = q[first]; 
            first = next(first); 
            a++; 
        }
    }

    public String tostring(){
        return String.format("{first: %d, last:%d}", first, last);
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String word = sc.next();
            if(word.equals("end")) break; 
            if(word.equals("-"))
                System.out.println(queue.dequeue()); 
            else
                queue.enqueue(word);
        }
        sc.close(); 
        System.out.println(queue.toString());
    }
}
