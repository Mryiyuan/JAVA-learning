public class ArrBinaryTree {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        ArrBinaryTreeDemo abd = new ArrBinaryTreeDemo(arr);
        abd.preOrder();

    }
}
class ArrBinaryTreeDemo{
    private int[] arr;
    public ArrBinaryTreeDemo(int[] arr){
        this.arr = arr;
    }
    //前序
    //重载
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int index){
        //如果传进来的数组为空，len=0
        if(arr==null||arr.length == 0){
            System.out.println("arr.null");
        }
        //前序DLR
        System.out.println(arr[index]);
        //左子节点递归
        if((index * 2 + 1)<arr.length){
            preOrder(index * 2 + 1);

        }
        //右子节点递归
        if((index * 2 + 2)<arr.length){
            preOrder(index * 2 + 2);

        }
    }
    //中序
    //后序
}