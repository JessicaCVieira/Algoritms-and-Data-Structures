package Semana06;

//3 linhas de mudança de código
//interface usado para não repetir codigo
//n muda a ordem de grandeza mas o tempo é menor. tendem as duas para o n^2

public class InsertionUpdated {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T aux = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (less(aux, array[j - 1])) { // comp
                    array[j] = array[j - 1];
                } else {
                    array[j] = aux;
                    break;
                }
            }
            //array[j] = aux;
        }
    }

    //TODO-> arranjar o warning do comparable 
    private static boolean less(Comparable t, Comparable e) {
        return t.compareTo(e) < 0;
    }

    public static void main(String[] args) {
        // Definir o tamanho do array
        int n = 10;
        String[] array = new String[n];
        // inserir valores aleatórios no array
        // se for inteiro
        for (int i = 0; i < array.length; i++) {
            array[i] = "" + (int) (Math.random() * n); // vetor de strings que tem numeros lá dentro
        }
        // imprimir o array
        System.out.println("Array antes:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // tempo de execução inicial
        double start = System.currentTimeMillis();
        // ordenar o array
        sort(array);
        // tempo de execução final
        double end = System.currentTimeMillis();

        // imprimir o array ordenado
        System.out.println("Array depois:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Doubling Hypothesis
        System.out.println("Doubling Hipothesis:");
        double prevTime = 0.0; 
        double ratio = 0.0; 
        double log = 0.0; 

        System.out.println("N\t\tT(N) (s)\t\tRatio\t\tLog(Ratio)");

        //for (int i = ; i < ; i)


    }
}
