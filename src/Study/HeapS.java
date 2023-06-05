package Study;

public class HeapS {
    
    public static void sort(Comparable[] pq) {

        //define o comprimento do array
        int n = pq.length;

        // heapify phase

        //percorre os nós apartir da 1ª metade até ao índice 1.
        //começa a metade pq todos os nós após o meio são folhas ent não precisam de ser ajustados
        for (int k = n/2; k >= 1; k--){
        
            //A função sink é usada para ajustar o nó k no Heap
            sink(pq, k, n);
        }


        // sortdown phase

        int k = n; // k = índice do último elemento do array
        while (k > 1) { // até que k = 1 ou seja tds os elementos do array estão ordenados
            exch(pq, 1, k--); //chamado para trocar o elemento na pos 1 (root) com o elemento da pos k 
                                //decrementa-se k 
            sink(pq, 1, k);//chamado para ajustar o nó raiz no heap atualizado
        }
    }

   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private static void sink(Comparable[] pq, int k, int n) {

        //enquanto o nó atual tem pelo menos um nó filho 
        while (2*k <= n) {

            int j = 2*k; //j é o índice do filho esquerdo do nó atual (k)

            //verificar se o nó atual tem um filho direito
            //se tiver compara os filhos esquerdo e o direito para determinar qual é o maior
            //se o direito for maior a variável j é atualizada para o índice do filho direito
            if (j < n && less(pq, j, j+1)) j++;

            //verificar se o nó atual é maior ou igual ao valor do maior filho (j)
            //se estiver o heap está em ordem e o loop acaba
            if (!less(pq, k, j)) break;

            //troca os valores de k e j 
            exch(pq, k, j);

            //k passa a ser o indice do filho j 
            k = j;
        }
    }

   /***************************************************************************
    * Helper functions for comparisons and swaps.
    * Indices are "off-by-one" to support 1-based indexing.
    ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        //se pq[i-1] emnor que pq[j-1] retorna true 
        //se não dá false
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    //troca pq[i-1] com pq[j-1]
    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }


    //Para testar 
    //devolve um array aleatório de inteiros 
    public static Integer[] randomIntAray(int n){
        Integer[] a = new Integer[n]; 
        for(int i = 0; i < a.length; i++){
            a[i] = (int) (Math.random()*n);
        }
        return a; 
    }

    //print do array 
    public static void printArray(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }   

    public static void main(String[] args){
        //criar um array
        Integer[] array = randomIntAray(10); 
        //imprimir o array; 
        printArray(array);
        //ordenar o array
        sort(array);
        //imprimir o array
        System.out.println("Array depois: ");
        printArray(array);
    }
   
}



