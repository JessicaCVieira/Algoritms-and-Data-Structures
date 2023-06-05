package Study;

import java.util.NoSuchElementException;

public class MaxPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq; //array da pq
    private int N; // nº de intens da pq


    //CONSTRUTORES 
    //inicializa uma MaxPq vazia    
    public MaxPriorityQueue(){
        this.pq = null; 
        this.N = 0; 

    }

    //inicializa a MaxPq com o vetor de Keys que é dado; 
    public MaxPriorityQueue(Key[] a){
        N = a.length; 
        for(int i = 0; i < N + 1; i++){
            this.pq[i+1] = a[i]; 
        }
        for(int i = N/2; i >= 1; i--){ //enquanto for pai
            sink(i); 
        }
        
    }

    //METODOS
    public void insert(Key v){
        pq[++N] = v; 
        swim(N); 
    }

    //Não esquecer das exceções 
    public Key getMax(){
        if(isEmpty()) throw new NoSuchElementException ("A queue está vazia"); 
        return pq[1]; 
    }

    public Key delMax(){
        Key max = getMax(); 
        exchange(1, N--); 
        sink(1); 
        pq[N + 1] = null; 
        return max; 

    }

    public boolean isEmpty(){
        return N==0;
    }
    
    public int size(){
        return N - 1; 
    }

    private void sink(int k){
        while(2*k < N){
            if(less(k/2, 2*k) || less(k/2, 2*k +1)){
                if(less(2*k, 2*k+1 )){
                    exchange(k/2, 2*k+1);
                    k = 2*k +1; 
                }else{
                    exchange(k/2, 2*k);
                    k = 2*k; 
                }
            }
        }
    }

    //Função do prof
    /*private void sink2 (int k){
        while(2*k <= N){
            int j = 2*k; 
            if(j < N && less(j, j +1)){
                j++; 
            }
            if(!less(k, j)) break; 
            exchange(k, j);
            k = j; 
        }
    }*/

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exchange(k, k/2);
            k = k/2; 
        }

    }

    private void exchange(int i, int j){
        Key aux = pq[i]; 
        pq[i] = pq[j]; 
        pq[j] = aux; 
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0; 

    }


}
