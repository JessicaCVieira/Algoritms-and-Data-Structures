package Semana02;

public class QuickFindUF{

    private int[] id; 

    public QuickFindUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p){
        return id[p] == id[q]; //ñ sei pq é que está a dar erro, está igual aos dois ptt
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
        for(int i = 1000; i < 256000 ; i*= 2){
            QuickFindUF quickFind = new QuickFindUF(i);
            long start = System.currentTimeMillis(); 
            for(int j = 0; j < i; j++){
                //TODO
                quickFind.union(0/*random*/,0/*random */);
            }
            long end = System.currentTimeMillis(); 
        }

    }

}

