// InsertionSortDichotomyDemo1.java

class InsertionSortDichotomyDemo1{

    void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println();
    }

    void InsertionSortDichotomy(int[] data){
        int n = data.length;
        for(int i = 1; i < n; i++){
            int get = data[i];
            int left = 0;
            int right = i - 1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(data[mid] > get){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            for(int j = i - 1; j >= left; j--){
                data[j + 1] = data[j];
            }
            data[left] = get;
        }
    }

    public static void main(String[] args){
        // int _source[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int _source[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        InsertionSortDichotomyDemo1 isdd = new InsertionSortDichotomyDemo1();
        isdd.displayData(_source);
        isdd.InsertionSortDichotomy(_source);
        isdd.displayData(_source);
    }
}