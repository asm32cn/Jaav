// SelectionSortDemo1.java

class SelectionSortDemo1{
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

    void selectionSort(int[] data){
        int n = data.length;
        for(int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(data[j] < data[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(data, min, i);
            }
        }
    }

    public static void main(String[] args){
        // int _source[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int _source[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        SelectionSortDemo1 ssd = new SelectionSortDemo1();
        ssd.displayData(_source);
        ssd.selectionSort(_source);
        ssd.displayData(_source);
    }
}