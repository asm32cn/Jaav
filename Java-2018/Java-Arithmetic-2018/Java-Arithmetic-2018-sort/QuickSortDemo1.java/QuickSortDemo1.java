// QuickSortDemo1.java

class QuickSortDemo1{
    void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println();
    }

    void QuickSort(int[] data, int left, int right){
        if(left < right){
            int key = data[left];
            int low = left;
            int high = right;
            while(low < high){
                while(low < high && data[high] >= key){
                    high--;
                }
                data[low] = data[high];
                while(low < high && data[low] <= key){
                    low++;
                }
                data[high] = data[low];
            }
            data[low] = key;

            QuickSort(data, left, low - 1);
            QuickSort(data, low + 1, right);
        }
    }

    public static void main(String[] args){
        // int _source[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int _source[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        QuickSortDemo1 qsd = new QuickSortDemo1();
        qsd.displayData(_source);
        qsd.QuickSort(_source, 0, _source.length - 1);
        qsd.displayData(_source);
    }
}