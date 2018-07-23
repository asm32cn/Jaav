// BucketSortDemo1.java

class BucketSortDemo1{
    private final int MAX = 100;
    private final int bn = 5;
    private final int nfactor = (MAX % bn) == 0 ? MAX / bn : MAX / bn + 1;
    private int[] C = new int[bn];

    private void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0) System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    private void insertionSort(int[] data, int left, int right){
        for(int i = left + 1; i <= right; i++){
            int get = data[i];
            int j = i - 1;
            while(j >= left && data[j] > get){
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = get;
        }
    }

    private int mapToBucket(int x){
        return x / nfactor;
    }

    private void countingSort(int[] data){
        int n = data.length;
        for(int i = 0; i < bn; i++){
            C[i] = 0;
        }
        for(int i = 0; i < n; i++){
            C[mapToBucket(data[i])]++;
        }
        for(int i = 1; i < bn; i++){
            C[i] = C[i] + C[i - 1];
        }
        int[] B = new int[n];
        for(int i = n - 1; i >= 0; i--){
            int b = mapToBucket(data[i]);
            B[--C[b]] = data[i];
        }
        for(int i = 0; i < n; i++){
            data[i] = B[i];
        }
    }

    public void BucketSort(int[] data){
        countingSort(data);
        for(int i = 0; i < bn; i++){
            int left = C[i];
            int right = (i == bn - 1 ? data.length - 1 : C[i + 1] - 1);
            if(left < right){
                insertionSort(data, left, right);
            }
        }
    }

    public static void main(String[] args){
        // int[] data = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int[] data = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        BucketSortDemo1 bsd = new BucketSortDemo1();
        bsd.displayData(data);
        bsd.BucketSort(data);
        bsd.displayData(data);
    }
}