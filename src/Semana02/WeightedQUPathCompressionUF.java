package Semana02;

import java.util.Random; 

public class WeightedQUPathCompressionUF {
    
    private int[] id;
    private int[] sz;  

    public WeightedQUPathCompressionUF (int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while (i != id[i]){
            id[i] = id[id[i]]; 
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if(rp == rq){
            return; 
        }
        if(sz[rp] < sz[rq]){
            id[rp] = rq; 
            sz[rq] += sz[rp];
        }else{
            id[rq] = rp;
            sz[rp] += sz[rq];
        }
    }

    public static void main(String[] args) {
        
        double previousTime = 0.0; 
        double ratio = 0.0; 
        double log = 0.0; 

        //header
        System.out.println("N\t\tT(N) (s)\t\tRatio\t\tLog(Ratio)");
        
        for(int i = 1000; i <= 32000; i*= 2){
            WeightedQUPathCompressionUF pathCompression = new WeightedQUPathCompressionUF(i);
            
            double start = System.currentTimeMillis(); 
            
            for(int j = 0; j < i; j++){
                Random random = new Random(); 
                pathCompression.union(random.nextInt(i), random.nextInt(i));
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
