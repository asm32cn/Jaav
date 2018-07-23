// InsertionSortDemo1.java

class InsertionSortDemo1{
    private void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0) System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    public void InsertionSort(int[] data){
        int n = data.length;
        for(int i = 0; i < n; i++){
            int get = data[i];
            int j = i - 1;
            while(j >= 0 && data[j] > get){
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = get;
        }
    }

    public static void main(String[] args){
        // int data[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int data[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        InsertionSortDemo1 isd = new InsertionSortDemo1();
        isd.displayData(data);
        isd.InsertionSort(data);
        isd.displayData(data);
    }
}