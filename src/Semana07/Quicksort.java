
public class Quicksort {
      
    public static void sort (Comparable[] array){
        //Baralhar o array
        shuffle(array);
        sort (array, 0, array.length - 1);
    }

    //versão recursiva
    private static void sort (Comparable[] array, int lo, int hi){
        if(hi<=lo){
            return; 
        }
        int j = partition(array, lo, hi); 
        sort(array, lo, j-1);
        sort(array, j+1, hi); 
    }

    private static int partition(Comparable[] array, int lo, int hi){
        //partição => array[lo]
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

    //o main é igual ao da semana passada 
    public static void main(String[] args){
        //Definir o tamanho do array
        int n = 10; 
        String[] array = new String[n]; 
        //inserir valores aleatórios no array
        //se for inteiro
        for(int i = 0; i < array.length; i++){
            array[i] = "" + (int)(Math.random()*n);     //vetor de strings que tem numeros lá dentro
        }
        //imprimir o array
        System.out.println("Array antes:");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //tempo de execução inicial
        //ordenar o array
        sort(array); 
        //tempo de execução final

         //imprimir o array ordenado
         System.out.println("Array depois:");
         for(int i = 0; i < array.length; i++){
             System.out.print(array[i] + " ");
         }
         System.out.println();
        
        }
}
