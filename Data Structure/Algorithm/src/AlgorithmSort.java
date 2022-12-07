import java.util.Arrays;
import java.util.Random;

public class AlgorithmSort {
    public int[]  GenerateArray(int len,int max) {
        System.out.println("-------------------------------generate the random int array-------------------------------------------");
        int[] arr = new int[len];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            int number = random.nextInt(max) + 1;
            for(int j = 0;j <=i;j++){
                if(number != arr[j]){
                    arr[i]=number;
                }
                else if(number == arr[j]){
                    number = random.nextInt(max) + 1;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public  int BubbleSort(int[] arr){
        System.out.println("-------------------------------BubbleSort-------------------------------------------");
        for(int i = 0;i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("No."+ (i+1) + " round" + Arrays.toString(arr));
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("after bubble sort");
        System.out.println(Arrays.toString(arr));
        return -1;

    }
    public int[] SelectionSort(int[] arr){
        System.out.println("-------------------------------SelectionSort-------------------------------------------");

        int temp =0;
//    外层循环表示选择排序的次数，思考这样一个问题，有n个元素的数组，需要选择排序多少次？答案是n-1次，每次选择排序就是将剩下的最小的值放到最前，第一次，把最小的放到最前，第二次把第二小的放到第二个位置，第n-1次，把第二大的放到倒数第二个位置，此时选择排序已经完成，因为最大的数就是在最后一个位置了。所以外层循环就应该是：for (int i=0;i<arr.length-1;i++)，这里arr.length就是数组元素个数n，在选择排序次数确定的情况下，内层循环就可以变为：for (int j=i+1;j<arr.length;j++)。

        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.println("No."+ (i+1) + " round" + Arrays.toString(arr));
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("after SelectionSort");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    //插入排序是将新数据插入到已经排序好的数组（由小到大）
    public int InsertSort(int[] arr){
        System.out.println("-------------------------------InsertSort-------------------------------------------");
        int insertValue = 0;
        int inserIndex = 0;
        for(int i = 1; i < arr.length;i++){
            insertValue = arr[i];
            inserIndex = i - 1;
            //example:when i = 1, insertValue = arr[i] = a[1], arr[inserIndex] = a[i-1] = a[0]
            //inserIndex 必须 >=0;
            //insertValue < arr[inserIndex],arr[inserIndex]后移，原本的位置给insertValue
            //insertValue > arr[inserIndex],arr[inserIndex]不用后移
            while(inserIndex >=0 && insertValue < arr[inserIndex]){
                //后移
                arr[inserIndex + 1 ] = arr[inserIndex];
                inserIndex--;
            }
            if(inserIndex != i-1){
                arr[inserIndex + 1 ] = insertValue;

            }
            System.out.println("No."+ (i+1) + " round" + Arrays.toString(arr));
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("after SelectionSort");
        System.out.println(Arrays.toString(arr));
        return -1;
    }
    public int  ShellSort(int[] arr){
        System.out.println("-------------------------------ShellSort-------------------------------------------");
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){//左侧
                for(int j = i - gap; j >= 0;j-=gap){//右侧
                    if(arr[j]>arr[j + gap]){
                        int temp = arr[j];
                        arr[j] = arr[ j + gap ];
                        arr[ j + gap ] = temp;
                    }

                }

            }
            System.out.println(Arrays.toString(arr));

        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("after ShellSort");
        System.out.println(Arrays.toString(arr));
        return -1;
    }

    //希尔排序位移法，在分组时先插入排序
    public int  ShellSort2(int[] arr){
        System.out.println("-------------------------------ShellSort2-------------------------------------------");
        int temp = 0;
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){//左侧
              int j = i;
              temp = arr[j];
              if(temp < arr[j-gap]){
                  while(j-gap>=0 && temp < arr[j-gap]){
                      arr[j] = arr[j-gap];
                      j-=gap;
                  }
                  arr[j]=temp;

              }

            }
            System.out.println(Arrays.toString(arr));

        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("after ShellSort2");
        System.out.println(Arrays.toString(arr));
        return -1;
    }
    public int QuickSort(int[] arr, int low, int high){
      //  System.out.println("-------------------------------QuickSort-------------------------------------------");
        if(low < high){
            int pivot = arr[low];//设定基准值
            int left = low;
            int right =high;
            //先处理右边，后处理左边
            while(left<right){
                //处理右边，找到小于pivot的元素，exit循环时，右边全是大于pivot的元素,把和基准数相同的数也放在右边
                while(left<right && arr[right]>=pivot){
                    //获取小于基准数的下标
                    right--;
                }
                //把右边小于基准数的元素给左边
                arr[left]=arr[right];
                //处理左边
                //处理左边，找到大于pivot的元素，exit循环时，左边全是小于pivot的元素,
                while(left<right && arr[left]  < pivot){
                    //左边开始无值，然后递增，所以++
                    left++;
                }
                //把左边大于基准值的元素给右边
                arr[right]=arr[left];
            }
            arr[left]=pivot;
            //划分为左部分处理左边部分用到递归
            QuickSort(arr,low,left-1);
            //处理右边
            QuickSort(arr,left+1,high);
        }else{
            return -1;
        }
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("after QuickSort");
//
        return -1;
    }

    //MergeSort

    /*
     * arr要排序的数组
     * left数组左边
     * mid数组中间suoyin
     * right数组右边索引
     * temp临时数组
     * */
    public  int Sort(int[] arr, int left,  int right, int[] temp){
        if(left<right){
            int mid = ( left + right)/2;

            //排序左边
            Sort(arr, left, mid, temp);

            //排序右边
            Sort(arr,mid+1, right, temp);

            //合并
            Merge(arr, left, mid, right, temp);
        }

        return  -1;
    }
    public int Merge(int[] arr, int left, int mid, int right, int[] temp){


        int leftIndex = left;
        int rightIndex = mid + 1;
        int k = 0;
        //把左边和右边两个序列合并成一个有序序列
        while(leftIndex<=mid && rightIndex<=right) {
            //如果左边元素大于右边元素，索引++
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[k++] = arr[leftIndex++];
            } else {
                temp[k++] = arr[rightIndex++];
            }
        }
            //把左边剩余的数据放入temp
            while(leftIndex<=mid){
                temp[k++]=arr[leftIndex++];
            }
            //把右边剩余的数据放入temp
            while(rightIndex<=right){
                temp[k++]=arr[rightIndex++];
            }
            //把temp的数据赋值给原数组
            k = 0;
            int templeft = left;
            while(templeft<=right){
                arr[templeft++]=temp[k++];

        }
            return -1;
    }
//基数排序
    public int RadixSort(int[] arr){
        //cus I dont know how many nums should be in buckets
        //它的存放数即数组的大小
        //基数排序是空间 换时间
        int[][] bucket= new int[10][arr.length];
        int[] bucketCounts = new int[10];

        //确定数组中最大值后，确定位数
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        //确定位数
        int maxLength  = String.valueOf(max).length();

        System.out.println(maxLength);
        for(int i = 1,n=1; i <=maxLength; i++,n*=10){
            int index = 0;//索引
            for(int j = 0; j < arr.length;j++ ){
                //去对应的位数
                int nums = arr[j]/n%10;
                //给对应的桶赋值
                bucket[nums][bucketCounts[nums]] = arr[j];
                //记录每个桶的元素的个数
                bucketCounts[nums]++;
            }

            //把记录桶中元素的bucketCounts数组遍历
            //如果=0，跳过；否则，知道桶中元素的个数，按照个数遍历给原数组
            for(int j = 0; j < bucketCounts.length; j++){
                if(bucketCounts[j] != 0){
                    for(int k = 0; k < bucketCounts[j];k++){
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketCounts[j] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }


        return -1;
    }


}
