package Study;

import java.util.NoSuchElementException;

public class MinPQ<Key extends Comparable<Key>> {

    private int N; 
    private Key[] pq; 
    
    //CONSTRUTORES 
    public  MinPQ(){
        this.N = 0; 
        this.pq = null; 
    }

    public MinPQ(Key[] a){
        N = a.length; 
        for(int i = 0; i <= N; i++){
            pq[i + 1] = pq[i]; 
        }
        for(int i = N/2; i >=1; i--){
            sink(i); 
        }
    }


    //METODOS
    public void insert(Key a){
        pq[++N] = a; 
        swim(N); 
    }

    public Key delMin(){
        if(isEmpty()) throw new NoSuchElementException("A Queue está vazia"); 
        Key min = pq[1]; 
        exchange(1, N--); 
        sink(1); 
        pq[N +1] = null; 
        return min; 
    }

    public boolean isEmpty(){
        return (N==0); 
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exchange(k/2, k);

        }
    }

    private void sink(int k){

    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j] < 0);
    }

    private void exchange(int i, int j){
        Key aux = pq[i]; 
        pq[i] = pq[j]; 
        pq[j] = aux; 
    }
}