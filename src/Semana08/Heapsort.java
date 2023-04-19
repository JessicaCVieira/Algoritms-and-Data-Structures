package Semana08;
//entregar dia 7 de maio
public class Heapsort {
    
    //ordenar o a[1.....a.length - 1]; 
    public static void sort(Comparable[] a){
        int N = a.length - 1; 

        //Heapify
        for(int i = N/2; i <= 1; i--){
            sink(a, i, N); 
        }

        //Sortdown
        while(N > 1){
            //Trocar a pos 1 (Máx) com a pos N 
            exchange(a, 1, N); //ou  exchange(a, 1, N--);
            //decrementar N
            N--; 
            //Sink de 1(que é a raiz)
            sink(a, 1, N); 
        }

    }

    private static void sink(Comparable[] a, int i, int N){
        //2 critérios de paragem: cheguei numa folha, quando for >= ao maior dos seus filhos 
        //filhos: 2*i e 2*i+1
        while(2*i <= N){
            //verificar quem é o maior dos filhos 
            int j = 2*i; //estamos a considerar que o filho da esquerda é o maior

            //Compara com o filho da direita
            if( j+1 <= N && less(a, j, j+1)){
                j++; 

                //só trocamos se o filho for maior que o pai / se ou pai for menor que o filho troca
                if(less(a, i, j)){
                    exchange(a, i, j);
                }else{
                    break; 
                }
                i = j; //para descer na arvore
            }
            //quando sair o j é o indice do maior dos filhos

        } 

    }

    private static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0; 
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

    public static void main(String[] args){
        //criar um array
        Integer[] array = randomIntAray(3); 
        //imprimir o array; 
        printArray(array);
        //ordenar o array
        sort(array);
        //imprimir o array
        System.out.println("Array depois: ");
        printArray(array);
    }


}
