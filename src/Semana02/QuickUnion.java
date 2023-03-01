package Semana02;

import java.util.Random;

public class QuickUnion {
    
    private int[] id;  

    public QuickUnion(int N) {
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
        id[rp] = rq;
    }

    public static void main(String[] args) {
        int count = 0; 
        long previousTime = 0; 
        long ratio = 0; 
        double logaritmo = 0; 
        long averageRatio = 0; 
        long estimatedTime = 0; 
        for(int i = 1000; i <= 256000 ; i*= 2){
            QuickUnion quickUnion = new QuickUnion(i); 
            long start = System.currentTimeMillis(); 
            count = count++; 
            for(int j = 0; j < i; j++){
                Random random = new Random(); 
                quickUnion.union(random.nextInt(i), random.nextInt(i));
            }
            long end = System.currentTimeMillis(); 

            long time = end-start; 
            previousTime = time; 
            if(previousTime!=0){
                ratio = time / previousTime; 
                logaritmo = Math.log(ratio) / Math.log(2) ; 
            } 

            averageRatio = averageRatio/count; 
            estimatedTime = averageRatio * 10^9; 

            //TODO -> previous time 
            //TODO -> System.out.prints (a tabela dos dados)
            System.out.println("N\t");
        }

    }
}
        
