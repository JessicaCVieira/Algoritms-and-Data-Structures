package Semana02;

public class WeightedQUPathCompressionUF {
    
    private int[] id;
    private int[] sz;  

    public void QuickUnionUF(int N) {
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

}
