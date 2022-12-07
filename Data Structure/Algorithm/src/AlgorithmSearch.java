import java.util.Arrays;

class AlgorithmSearch {
    //BinarySearch
    public int BinarySearch(int[] arr, int left, int right, int key){
        System.out.println("-------------------------------二分查找-------------------------------------------");
        while(left <= right){
            int mid = ( left + right ) / 2 ;
            if ( key == arr[mid])
                return mid;
            if ( key > arr[mid])
                left = mid + 1;
            if ( key < arr[mid])
                right = mid - 1;
        }
        return -1;
    }
    public int BinarySearchRecursion(int[] arr, int left, int right, int searchValue){
        System.out.println("-------------------------------二分查找递归-------------------------------------------");

        if(left<=right){
          //  int mid = ( left + right )/2;
            //定义mid 的自适应系数，优化二分查找
            int mid = left + (searchValue - arr[left])/(arr[right]-arr[left])*(right - left);
            if(searchValue < arr[mid]){
                return BinarySearchRecursion(arr, left, mid-1, searchValue);
            }else if(searchValue > arr[mid]){
                return BinarySearchRecursion(arr, mid+1, right, searchValue);
            }else{
                return mid;
            }
        }
        return -1;
    }
    //可以查找无序数组
    public int LinerSearch(int[] arr, int searchValue){
        System.out.println("-------------------------------线性寻找-------------------------------------------");
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] == searchValue){
                System.out.println(i);
            return i;

            }
        }
        return -1;
    }
//循环算法创造斐波那契数列
    public int[] Fibonacci(int n){
        System.out.println("-------------------------------创建斐波那契数列-------------------------------------------");
        int[] k = new int[n];
        k[0] = 0;
        k[1] = 1;
        k[2] = 1;
        for(int i = 3; i < n; i++){
            k[i] = k[i-1] + k[i-2];
        }
        System.out.println(Arrays.toString(k));
        return k;

    }
    //递归算法创造斐波那契数列
    public int FibonacciRecursion(int n){
        System.out.println("-------------------------------斐波那契寻找-------------------------------------------");
        if(n == 1){
            return 0;
        } if (n==2) {
            return 1;
        }
        return  FibonacciRecursion(n-1)+FibonacciRecursion(n-2);

    }
    public int FibonacciSearch(int[] arr, int right, int left, int key){

        return -1;
    }
}
