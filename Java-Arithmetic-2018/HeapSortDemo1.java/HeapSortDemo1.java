// HeapSortDemo1.java

class HeapSortDemo1{
    public void displayData(int[] data){
        int n = data.length;
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    private void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void heapify(int[] data, int i, int size){
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if(leftChild < size && data[leftChild] > data[max]){
            max = leftChild;
        }
        if(rightChild < size && data[rightChild] > data[max]){
            max = rightChild;
        }
        if(max != i){
            swap(data, i, max);
            heapify(data, max, size);
        }
    }

    public void HeapSort(int[] data){
        // BuildHeap
        int n = data.length;
        int heapSize = n;
        for(int i = heapSize / 2 - 1; i >= 0; i--){
            heapify(data, i, heapSize);
        }
        // HeapSort
        while(heapSize > 1){
            swap(data, 0, --heapSize);
            heapify(data, 0, heapSize);
        }
    }

    public static void main(String[] args){
        // int data[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int data[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        HeapSortDemo1 hsd = new HeapSortDemo1();
        hsd.displayData(data);
        hsd.HeapSort(data);
        hsd.displayData(data);
    }
}