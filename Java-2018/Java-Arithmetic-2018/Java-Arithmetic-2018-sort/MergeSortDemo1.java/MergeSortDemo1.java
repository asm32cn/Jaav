// MergeSortDemo1.java

class MergeSortDemo1{
    private void displayData(int[] data){
        for(int i = 0, l = data.length; i < l; i++){
            if(i > 0) System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.println();
    }

    private void merge(int[] data, int left, int mid, int right){
        int len = right - left + 1;
        int[] temp = new int[len];
        int index = 0;
        int i = left;
        int j = mid + 1;
        while(i <= mid && j <= right){
            temp[index++] = data[i] <= data[j] ? data[i++] : data[j++];
        }
        while(i <= mid){
            temp[index++] = data[i++];
        }
        while(j <= right){
            temp[index++] = data[j++];
        }
        for(int k = 0; k < len; k++){
            data[left++] = temp[k];
        }
    }

    // 递归实现的归并排序(自顶向下)
    public void MergeSortRecursion(int[] data, int left, int right){
        // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
        if(left == right) return;

        int mid = (left + right) / 2;
        MergeSortRecursion(data, left, mid);
        MergeSortRecursion(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    // 非递归(迭代)实现的归并排序(自底向上)
    public void MergeSortIteration(int[] data){
        int len = data.length;
        // 子数组索引，前一个为A[left ... mid]，后一个为A[mid + 1 ... right]
        int left, mid, right;
        // 子数组的大小i初始为1，没轮翻倍
        for(int i = 1; i < len; i *= 2){
            left = 0;
            // 后一个子数组存在(需要归并)
            while(left + i < len){
                mid = left + i - 1;
                // 后一个子数组大小可能不够
                right = mid + i < len ? mid + i : len - 1;
                merge(data, left, mid, right);
                // 前一个子数组索引向后移动
                left = right + 1;
            }
        }

    }

    public static void main(String[] args){
        // int data1[] = {41, 67, 34, 0, 69, 24, 78, 58, 62, 64, 5, 45, 81, 27, 61, 91, 95, 42, 27, 36};
        int[] data1 = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};
        int[] data2 = {76, 11, 11, 43, 78, 35, 39, 27, 16, 55, 1, 41, 24, 19, 54, 7, 78, 69, 65, 82};

        MergeSortDemo1 msd = new MergeSortDemo1();
        msd.displayData(data1);
        msd.MergeSortRecursion(data1, 0, data1.length - 1);
        msd.displayData(data1);

        System.out.println();

        msd.displayData(data2);
        msd.MergeSortIteration(data2);
        msd.displayData(data2);
    }
}