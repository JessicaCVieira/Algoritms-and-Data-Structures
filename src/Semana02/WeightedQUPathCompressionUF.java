package Semana02;

import java.util.Random; 

public class WeightedQUPathCompressionUF {
    
    private int[] id;
    private int[] sz;  

    public WeightedQUPathCompressionUF (int N) {
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
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
        
        long previousTime = 0; 
        long ratio = 0; 
        double log = 0; 

        //header
        System.out.println("N\t\tT(N)\t\tRatio\t\tLog(Ratio)");
        
        for(int i = 1000; i <= 256000 ; i*= 2){
            WeightedQUPathCompressionUF pathCompression = new WeightedQUPathCompressionUF(i);
            
            long start = System.currentTimeMillis(); 
            
            for(int j = 0; j < i; j++){
                Random random = new Random(); 
                pathCompression.union(random.nextInt(i), random.nextInt(i)); // aqui esta a mandar um nullpointerexception
            }

            long end = System.currentTimeMillis(); 

            long time = end-start; 
            
            if(previousTime!=0){
                ratio = time / previousTime; 
                log = Math.log(ratio) / Math.log(2) ; 
            } 

            previousTime = time; 

            System.out.println(i + "\t\t" + time + "\t\t" + ratio + "\t\t" + log); 
        }

    }

}
