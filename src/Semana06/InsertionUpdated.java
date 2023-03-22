package Semana06;

//3 linhas de mudança de código
//interface usado para não repetir codigo
//n muda a ordem de grandeza mas o tempo é menor. tendem as 2 para o n^2

public class InsertionUpdated {
    public static <T extends Comparable<T>>void sort(T[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j > 0; j--){ //este for é diferente
                if(array[j].compareTo(array[j-1]) < 0) { //comp
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

