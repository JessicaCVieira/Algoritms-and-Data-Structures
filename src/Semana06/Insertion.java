package Semana06;

public class Insertion {
    public static <T extends Comparable<T>>void sort(T[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j].compareTo(array[j-1]) < 0) { 
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

        double previousTime = 0.0; 
        double ratio = 0.0; 
        double log = 0.0;

        //header
        System.out.println("----------Insertion-----------");
        System.out.println("N\t\tT(N) (s)\t\tRatio\t\tLog(Ratio)");

        //Definir o tamanho do array
        for(int n = 1000; n <= 32768000; n*= 2){
            String[] array = new String[n]; 

            for(int i = 0; i < array.length; i++){
                array[i] = "" + (int)(Math.random()*n);     
            }

            double start = System.currentTimeMillis();

            sort(array); 

            double end = System.currentTimeMillis(); 

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
