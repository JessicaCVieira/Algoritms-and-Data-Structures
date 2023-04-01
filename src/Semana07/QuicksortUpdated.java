package Semana07;

import Semana06.Insertion;

//do while (primeiro faz a ação depois incrementa)
//para parar uma função recursiva fazemos return (é preciso de haver uma condição de retorno)
//++i é o incremento antes
public class QuicksortUpdated {
    
    public static void sort (Comparable[] array){
        //Baralhar o array
        shuffle(array);
        sort (array, 0, array.length - 1);
    }

    //versão recursiva
    private static void sort (Comparable[] array, int lo, int hi){
        //parar com o array menor que 10, invocar insertion sort para ordenar o subarray
        if(hi<=lo + 10){      //paragem da recursão , só para a parte lo e hi temos que mudar o insertion sort de **lo até hi**
            Insertion.sort(array, lo, hi); 
            return; 
        }

        int mediana = medianaOf((int) array[0], (int) array[1], (int) array[2]);
        

        int j = partition(array, lo, hi); 
        sort(array, lo, j-1);
        sort(array, j+1, hi); 
    }

    private static int medianaOf(int a, int b, int c){
        Comparable[] vetor = {a, b, c};
        sort(vetor);
        int mediana1 = (int) vetor[1];
        return mediana1; 
    }

    public static class Insertion {
        //TODO -> alterar insertion para receber, array, lo, hi; 
        public static <T extends Comparable<T>>void sort(T[] array, int lo, int hi){
            for(int i = 0; i < hi+1; i++){
                for(int j = i; j > 0; j--){
                    if(array[j].compareTo(array[j-1]) < 0) { //comparação
                        //trocar sem usar o exchange (o que é pedido no ex)
                        T aux = array[j]; 
                        array[j] = array[j - 1]; 
                        array[j - 1] = aux; 
                    }else{
                       break;  
                    }
                }
            }
        }
    }

    private static int partition(Comparable[] array, int lo, int hi){
        //partição => array[lo]
        //TODO -> encontrar a mediana estimanad no lugar a[lo] - é preciso criar uma função extra
        int i = lo;
        int j = hi + 1; //pq decrementamos antes de testar

        /*se quisessemos usar o while 
        while(true){
            while (( i ! = hi) && less(array[++i], array[lo]))
        }
        */

        while(true){
            do{  //i
                i++; 
            }while((i != hi) && less(array[i], array[lo])); //array[i] < array[lo]

            do{ //j
                j--;  
            }while(less(array[lo], array[j])); //array[j] > array[lo]

            if(i >= j) break; 
            exchange(array, i , j); 
        }
        exchange(array, lo, j); 
        return j; 
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0; 
    }

    private static void shuffle (Comparable[] array){
        for(int i = 0; i < array.length; i++){
            int pos = (int) (Math.random()*(i+1)); 
            exchange(array, i, pos);
        }
    }

    public static void exchange(Comparable[] array, int i, int j){
        Comparable aux = array[j]; 
        array[j] = array[i]; 
        array[i] = aux; 
    }

    public static Integer[] randomIntAray(int n){
        Integer[] a = new Integer[n]; 
        for(int i = 0; i < a.length; i++){
            a[i] = (int) (Math.random()*n);
        }
        return a; 
    }

    public static void printArray(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }   

        //o main é igual ao da semana passada 
    public static void main(String[] args){
        //criar um array
        Integer[] array = randomIntAray(20); 
        //imprimir o array; 
        printArray(array);
        //ordenar o array
        sort(array);
        //imprimir o array
        System.out.println("Array depois: ");
        printArray(array);
    }

}