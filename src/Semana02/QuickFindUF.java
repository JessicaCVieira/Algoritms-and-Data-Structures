package Semana02;

import java.util.Random;

public class QuickFindUF{

    private int[] id; 

    public QuickFindUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return id[p] == id[q]; 
    }
    
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        
        double previousTime = 0.0; 
        double ratio = 0.0; 
        double log = 0.0; 

        //header
        System.out.println("N\t\tT(N)\t\tRatio\t\tLog(Ratio)");

        for(int i = 1000; i <= 256000 ; i*= 2){
            QuickFindUF quickFind = new QuickFindUF(i);

            double start = System.currentTimeMillis(); 
             
            for(int j = 0; j < i; j++){
                Random random = new Random(); 
                quickFind.union(random.nextInt(i), random.nextInt(i));
            }

            double end = System.currentTimeMillis(); 

            double time = (end-start)/1000.0; 
            
            if(previousTime!=0){
                ratio = Math.round((time / previousTime)*1000.0)/1000.0; 
                log = Math.round((Math.log10(ratio) / Math.log10(2))*1000.0)/1000.0 ;
            } 
            System.out.println(i + "\t\t" + time + "\t\t" + ratio + "\t\t" + log); 
            previousTime = time; 
        }
    }

}

