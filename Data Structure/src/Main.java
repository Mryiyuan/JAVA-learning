import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,1,3,4};
        System.out.println(Arrays.toString(arr));
        Main m = new Main();
        m.search(arr,3);




    }
    public int search(int[] arr,int key){
        int count = 0;
        for(int i = 0;i < arr.length; i++){
            if(arr[i]==key){
                System.out.println(i);
            } else {
                count++;
            }
        }
        System.out.println(count);
        if(count==arr.length){
            System.out.println("no");
        }

        return -1;
    }
}