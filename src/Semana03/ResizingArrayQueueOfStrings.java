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
        //criei outro vetor e no final atualizei o vetor "inicial"
        if(next(last)==first){
            String[] p = new String[2*q.length]; 
            q[first] = p[0];
            q[last] = p[q.length - 1];
            for(int i = 1; i < q.length - 1; i++){
                q[first + i] = p[i]; 
            }
            first = 0; 
            last = q.length; 
            p[last] = item; 
            this.q = p; 
        }

        //caso geral:
        last = next(last); 
        q[last] = item; 

        //vazia: 
        if(isEmpty()) first = last; 

        //não precisamos de fazer nada se só tiver um elemento, no dequeue já temos de fazer coisas quando o array só tem 1 elemento
    }

    //remove the least recently added item
    public String dequeue(){   //temos que mostrar o item que removemos na consola? 

        //1 elemento (temos de fazer resize aqui)
        if(first == last && 0 <= first && first <= q.length - 1){
            q[first] = null; 
        }

        //a 1/4 resize

        //vazia
        //recize quando está a 1/4 está a ser usado e o resto não
        //caso geral
        q[first] = null;
        first = first + 1;  
        int dif = 0; 
        if(q.length == 0.25*q.length){
            String[] p = new String[(int)0.5*q.length];
            q[first] = p[0];
            if(first > last){
                dif = first - last;
            }else{
                dif = last - first; 
            }
            q[last] = p[dif];
            for(int i = 1; i < dif - 1; i++){
                q[first + i] = p[i]; 
            }
            first = 0; 
            last = dif;
            this.q = p; 


        }
        return q[first]; 
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
