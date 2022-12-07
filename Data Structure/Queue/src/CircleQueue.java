/*
* 模拟淘汰小朋友问题
* 假设5个小朋友围成一圈而坐
* 从0开始报数，报到7淘汰
* 谁是最终赢家？*/


public class CircleQueue {
    private static int num = 7;

    public static void main(String[] args) {
        CircleQueueDemo CQ = new CircleQueueDemo(6);
        for (int i = 1; i <= 5; i++) {
            CQ.addValue(i);

        }
        CQ.showQueue();
        while (CQ.size() > 1) {
            for (int i = 0; i < num % CQ.size(); i++) {
                //把要娶出的数据之前的全部添加到末尾
                CQ.addValue(CQ.extractValue());

            }
            CQ.extractValue();
        }
        System.out.println(CQ.extractValue());
    }


}


//数组模拟顺序队列
class CircleQueueDemo{
    private int maxSize;//队列最大长度
    private int front;// 头指针
    private int rear;// 尾指针
    private int[] arr;

    public CircleQueueDemo(int maxSize){
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        arr = new int[maxSize];

    }
    //判断队列是否满
    public boolean isFull(){
        return rear == (rear + 1)%maxSize;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return  front == rear;

    }

    //添加数据
    //从末尾添加
    public void addValue(int value){
        //判断是否满
        if(isFull()){
            System.out.println("full");
        }else{

            arr[rear] = value;
            rear = (rear + 1)%maxSize;
        }

    }
    //取出数据
    //从头取，一个一个取出

    public int extractValue(){
        //判断是否空
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            int value = arr[front];
            front = (front + 1)%maxSize;
            return value;
        }
    }
    public void showQueue(){
        //判断是否空
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            for(int i = front; i < front+size(); i++){
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);

            }
        }
    }
    //为了只显示values,先求得size
    public int size(){
        return (rear + maxSize - front)%maxSize;
    }
    //展示front
    public int showHeadQueue(){
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            return arr[front];

        }
    }
    //展示rear
    public int showRearQueue(){
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            return arr[rear];

        }
    }

}