package Semana03;
//tenho de eliminar a package

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

    //add an item
    public void enqueue(String item){
        //cheia resized
        if(next(last)==first){
            String[] p = new String[2*q.length]; 
            q[first] = p[0];
            q[last] = p[q.length - 1];
            for(int i = 1; i < q.length - 1; i++){
                q[first + i] = p[i]; 
            }
            p[last] = item; 
        }

        //caso geral:
        last = next(last); 
        q[last] = item; 

        //vazia: 
        if(isEmpty()) first = last; 

        //não precisamos de fazer nada se só tiver um elemento, no dequeue já temos de fazer coisas quando o array só tem 1 elemento
    }

    //remove the least recently added item
    public String dequeue(){
        //cheia
        if(next(last)==first){
            q[]
        }


        //1 elemento (temos de fazer resize aqui)
        //caso geral



        //vazia
        //recize quando está a 1/4 está a ser usado e o resto não
    } 

    //is the queue empty?
    public boolean isEmpty(){
        if(first == -1) return true; 
        else return false; 
    }

    //number of items in the queue
    public int size(){
        if(first <= last)
            return last - first + 1;
        else
            return last + 1 + q.length - first; 
     

    } 

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings ();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String word = sc.next();
           if(word.equals("end")) break; 
                if(word.equals("-"))
                    System.out.print(queue.dequeue()); 
                else
                    queue.enqueue(word);
        }
        sc.close(); 
        System.out.println(queue.toString());
    }
}
