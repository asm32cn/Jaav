// CountingSortDemo1.java

class CountingSortDemo1{
    private final int k = 100;
    private int[] C = new int[k];

    private void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0) System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    public void CountingSort(int[] data){
        int n = data.length;
        for(int i = 0; i < k; i++){
            C[i] = 0;
        }
        for(int i = 0; i < n; i++){
            C[data[i]]++;
        }
        for(int i = 1; i < k; i++){
            C[i] = C[i] + C[i - 1];
        }
        int[] B = new int[n];
        for(int i = n - 1; i >= 0; i--){
            B[--C[data[i]]] = data[i];
        }
        for(int i = 0; i < n; i++){
            data[i] = B[i];
        }
    }

    public static void main(String[] args){
        // int data[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int data[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        CountingSortDemo1 csd = new CountingSortDemo1();
        csd.displayData(data);
        csd.CountingSort(data);
        csd.displayData(data);
    }
}