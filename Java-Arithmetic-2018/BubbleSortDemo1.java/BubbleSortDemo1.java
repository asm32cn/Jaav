// BubbleSortDemo1.java

class BubbleSortDemo1{
    void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println();
    }

    void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    void bubbleSort(int[] data){
        int n = data.length;
        for(int j = 0; j < n - 1; j++){
            for(int i = 0; i < n - 1 - j; i++){
                if(data[i] > data[i + 1]){
                    swap(data, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        // int _source[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int _source[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        BubbleSortDemo1 bsd = new BubbleSortDemo1();
        bsd.displayData(_source);
        bsd.bubbleSort(_source);
        bsd.displayData(_source);
    }
}