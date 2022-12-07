import java.util.Arrays;

public class AlgorithmTest {
    public  static void main(String args[]){
        int[] arr = { 4, 5, 7, 9, 11, 12, 13, 16, 79,178};

        AlgorithmSearch AlgorithmSearch = new AlgorithmSearch();
        AlgorithmSort AlgorithmSort = new AlgorithmSort();

        //long start = System.currentTimeMillis();

//        AlgorithmSearch.BinarySearch(arr,0, arr.length-1,178);
//        AlgorithmSearch.LinerSearch(arr,79);
//        AlgorithmSearch.BinarySearchRecursion(arr,0,arr.length-1,178);
//
//        AlgorithmSearch.Fibonacci(20);
       // int[] arr1 = AlgorithmSort.GenerateArray(20,100);
//        int[] arr2 = AlgorithmSort.GenerateArray(10,100);
//        AlgorithmSort.BubbleSort(arr1);
        //AlgorithmSort.SelectionSort(arr2);
        //AlgorithmSort.InsertSort(arr2);
        //AlgorithmSort.ShellSort2(arr2);
//        AlgorithmSort.QuickSort(arr2,0,arr.length-1);
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("after QuickSort");
//        System.out.println(Arrays.toString(arr2));

//        int[] arr3 = AlgorithmSort.GenerateArray(10,100);
//        int[] temp = new int[arr3.length];
//        AlgorithmSort.Sort(arr3,0,arr3.length-1,temp);
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("after MergeSort");
//        System.out.println(Arrays.toString(arr3));

        int[] arr4 = AlgorithmSort.GenerateArray(10,150);
        AlgorithmSort.RadixSort(arr4);
    }
}
