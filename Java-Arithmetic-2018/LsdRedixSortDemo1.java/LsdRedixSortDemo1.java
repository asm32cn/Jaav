// LsdRedixSortDemo1.java

class LsdRedixSortDemo1{
    private final int dn = 3;
    private final int k = 10;
    private int[] C = new int[k];

    private void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0) System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    private int getDigit(int x, int d){
        int[] radix = {1, 1, 10, 100};
        return (x / radix[d]) % 10;
    }

    private void CountingSort(int[] data, int d){
        int n = data.length;
        for(int i = 0; i < k; i++){
            C[i] = 0;
        }
        for(int i = 0; i < n; i++){
            C[getDigit(data[i], d)]++;
        }
        for(int i = 1; i < k; i++){
            C[i] = C[i] + C[i - 1];
        }
        int[] B = new int[n];
        for(int i =n - 1; i >= 0; i--){
            int dight = getDigit(data[i], d);
            B[--C[dight]] = data[i];
        }
        for(int i = 0; i < n; i++){
            data[i] = B[i];
        }
    }

    public void LsdRedixSort(int[] data){
        for(int d = 1; d < dn; d++){
            CountingSort(data, d);
        }
    }

    public static void main(String[] args){
        // int data[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int data[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        LsdRedixSortDemo1 lrsd = new LsdRedixSortDemo1();
        lrsd.displayData(data);
        lrsd.LsdRedixSort(data);
        lrsd.displayData(data);
    }
}