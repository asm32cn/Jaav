// ShellSortDemo1.java

class ShellSortDemo1{
    private void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0) System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    public void ShellSort(int[] data){
        int n = data.length;
        int h = 0;
        while(h <= n){
            h = 3 * h + 1;
        }
        while(h >= 1){
            for(int i = h; i < n; i++){
                int j = i - h;
                int get = data[i];
                while(j >= 0 && data[j] > get){
                    data[j + h] = data[j];
                    j = j - h;
                }
                data[j + h] = get;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args){
        // int data[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int data[] = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        ShellSortDemo1 ssd = new ShellSortDemo1();
        ssd.displayData(data);
        ssd.ShellSort(data);
        ssd.displayData(data);
    }
}