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

    public static void main(String[] args){

        double previousTime = 0.0; 
        double ratio = 0.0; 
        double log = 0.0;

        //header
        System.out.println("---------Insertion Updated---------");
        System.out.println("N\t\tT(N) (s)\t\tRatio\t\tLog(Ratio)");

        //Definir o tamanho do array
        for(int n = 1000; n <= 32768000; n*= 2){
            String[] array = new String[n]; 

            double start = System.currentTimeMillis();

            for(int i = 0; i < array.length; i++){
                array[i] = "" + (int)(Math.random()*n);     
            }

            double end = System.currentTimeMillis(); 

            sort(array); 

            double time = (end-start)/1000.0; 
            
            if(previousTime!=0){
                ratio = Math.round((time / previousTime)*1000.0)/1000.0; 
                log = Math.round((Math.log10(ratio) / Math.log10(2))*1000.0)/1000.0 ;
            } 
            System.out.println(n + "\t\t" + time + "\t\t" + ratio + "\t\t" + log); 
            previousTime = time;

        }
    }
}
