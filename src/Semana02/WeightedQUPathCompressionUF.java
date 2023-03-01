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
        int count = 0; 
        long previousTime = 0; 
        long ratio = 0; 
        double logaritmo = 0; 
        long averageRatio = 0; 
        long estimatedTime = 0; 
        for(int i = 1000; i <= 256000 ; i*= 2){
            WeightedQUPathCompressionUF pathCompression = new WeightedQUPathCompressionUF(i);
            long start = System.currentTimeMillis(); 
            count = count++; 
            for(int j = 0; j < i; j++){
                Random random = new Random(); 
                pathCompression.union(random.nextInt(i), random.nextInt(i));
            }
            long end = System.currentTimeMillis(); 

            long time = end-start; 
            previousTime = time; 

            if(previousTime!=0){
                ratio = time / previousTime; 
                logaritmo = Math.log(ratio) / Math.log(2) ; 
            } 

            System.out.println("N\t\tT(N)\t\tRatio\t\tlog(Ratio)");
        }

    }

}
