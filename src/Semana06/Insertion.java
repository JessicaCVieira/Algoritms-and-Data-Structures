package Semana06;

public class Insertion {
    public static void sort(Comparable[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j].compareTo(array[j-1]) < 0) { //comparação
                    //trocar sem usar o exchange (o que é pedido no ex)
                    Comparable aux = array[j]; 
                    array[j] = array[j - 1]; 
                    array[j - 1] = aux; 
                }else{
                   break;  
                }
            }
        }
    }

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
