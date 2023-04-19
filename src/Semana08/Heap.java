package Semana08;

public class Heap {
    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        // Heapify:
        for (int k = N / 2; k >= 1; k--)
        sink(a, k, N);
        // Sortdown:
        while (N > 1) {
        exchange(a, 1, N);
        sink(a, 1, --N);
        }
        }
        private static void sink(Comparable[] a, int k, int N) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && less(j, j + 1))
                j++;
                if (!less(k, j)) break;
                exchange(k, j);
                k = j;
            }
                
        }
        private static boolean less(Comparable[] a, int i, int j) {
            return a[i].compareTo(a[j]) < 0;
        }
        private static void exchange(Object[] a, int i, int j) {
            Comparable aux = a[j]; 
            a[j] = a[i]; 
            a[i] = aux; 
        }
    } 
}
